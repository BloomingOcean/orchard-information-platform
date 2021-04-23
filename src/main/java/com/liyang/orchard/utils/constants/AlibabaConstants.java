package com.liyang.orchard.utils.constants;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AlibabaConstants implements InitializingBean {

    @Value("${alibaba.endpoint}")
    private String endpoint;
    @Value("${alibaba.accessKeyId}")
    private String accessKeyId;
    @Value("${alibaba.accessKeySecret}")
    private String accessKeySecret;
    @Value("${alibaba.bucketName}")
    private String bucketName;
    @Value("${alibaba.signName}")
    private String signName;
    @Value("${alibaba.templateCode}")
    private String templateCode;

    public static String ENDPOINT;
    public static String ACCESSKEYID;
    public static String ACCESSKEYSECRET;
    public static String BUCKETNAME;
    public static String SIGNNAME;
    public static String TEMPLATECODE;

    @Override
    public void afterPropertiesSet() throws Exception {
        ENDPOINT = endpoint;
        ACCESSKEYID = accessKeyId;
        ACCESSKEYSECRET = accessKeySecret;
        BUCKETNAME = bucketName;
        SIGNNAME = signName;
        TEMPLATECODE = templateCode;
    }
}
