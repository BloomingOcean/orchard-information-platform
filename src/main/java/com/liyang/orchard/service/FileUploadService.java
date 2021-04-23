package com.liyang.orchard.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    /**
     * 上传文件
     * @param file
     */
    String upload(MultipartFile file);
}
