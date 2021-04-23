package com.liyang.orchard.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.liyang.orchard.service.FileUploadService;
import com.liyang.orchard.utils.constants.AlibabaConstants;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public String upload(MultipartFile file) {
        String endpoint = AlibabaConstants.ENDPOINT;
        String accessKeyId = AlibabaConstants.ACCESSKEYID;
        String accessKeySecret = AlibabaConstants.ACCESSKEYSECRET;
        String bucketName = AlibabaConstants.BUCKETNAME;

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        InputStream inputStream = null;
        try {
            // 获取文件流
            inputStream = file.getInputStream();
            // 获得文件名
            String fileName = file.getOriginalFilename();
            // 获取随机数
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            // 获取文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf("."));
            // fileName = 随机数 + 后缀
            fileName = uuid + suffix;
            // 获取当前时间，格式是"yyyy/MM/dd"
            String timeUrl = new DateTime().toString("yyyy/MM/dd");
            // fileName = timeUrl文件夹 下的  随机数 + 后缀
            fileName = timeUrl + "/" + fileName;
            // 传输到OSS中
            ossClient.putObject(bucketName, fileName, inputStream);
            // 拼接上传文件地址
            String fileUrl = "https://"+bucketName+"."+endpoint+"/"+fileName;
            ossClient.shutdown();
            return fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
