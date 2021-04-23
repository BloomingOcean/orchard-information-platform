package com.liyang.orchard.controller;

import com.liyang.orchard.core.Result;
import com.liyang.orchard.core.ResultGenerator;
import com.liyang.orchard.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/file")
@CrossOrigin
@Api(tags = "文件上传")
public class FileUploadController {

    @Resource
    private FileUploadService fileUploadService;

    @ApiOperation(value = "上传文件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result add(@RequestBody MultipartFile file) {
        return ResultGenerator.genSuccessResult(fileUploadService.upload(file));
    }
}
