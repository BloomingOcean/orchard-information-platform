package com.liyang.orchard.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.liyang.orchard.service.SmsService;
import com.liyang.orchard.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Value("${sms.accessKeyId}")
    private String accessKeyId;

    @Value("${sms.accessSecret}")
    private String accessSecret;

    @Value("${sms.signName}")
    private String signName;

    @Value("${sms.templateCode}")
    private String templateCode;

    @Override
    public boolean sendSms(String iponeNUmber) {
        // 连接阿里云生成客户端client
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        // 组装请求对象并用post发送
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        // 自定义参数 （手机号，签名，模版，验证码）
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", iponeNUmber);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        JSONObject object = new JSONObject();
        String randCode = getRandCode(6);
        log.info("验证码为：{}",randCode);
        object.put("code",randCode);
        request.putQueryParameter("TemplateParam", object.toJSONString());
        try {
            // 把验证码放在redis缓存中
            setVerfiCode(iponeNUmber, randCode);
        } catch (Exception e){
            log.error("{}",e);
        }
        try {
            // 发送验证码
            CommonResponse response = client.getCommonResponse(request);
            log.info(response.getData());
            return true;
        } catch (Exception e) {
            log.error("{}",e);
        }
        return false;
    }

    /**
     * 生成随机验证码
     * @param digits 验证码位数
     * @return 验证码
     */
    public static String getRandCode(int digits) {
        StringBuilder sBuilder = new StringBuilder();
        Random rd = new Random((new Date()).getTime());

        for(int i = 0; i < digits; ++i) {
            sBuilder.append(String.valueOf(rd.nextInt(9)));
        }

        return sBuilder.toString();
    }

    /**
     * 把手机号和验证码放置redis缓存中
     * @param iponeNUmber 手机号码
     * @param randCode 验证码
     */
    public static void setVerfiCode(String iponeNUmber, String randCode) {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.set(iponeNUmber,randCode);
        // 设置5分钟的过期时间
        redisUtil.expire(iponeNUmber,300);
    }
}
