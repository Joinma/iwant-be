package com.liori.controller.upload;

import com.liori.common.message.MessageEnum;
import com.liori.common.utils.message.MessageUtil;
import com.liori.common.utils.upload.UploadUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/upload")
public class UploadController {

    private final static Logger LOG = LoggerFactory.getLogger(UploadController.class);

    @Value("${file.preSavePath}")
    private String preSavePath;

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> uploadImage(
            @ApiParam(name = "上传文件", required = true) @RequestParam(value = "file") MultipartFile multipartFile) {
        try {
            // 上传文件名
            String fileName = multipartFile.getOriginalFilename();
            // 后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String pathName = "/test/" + System.currentTimeMillis() + suffixName;
            final String path = UploadUtil.uploadSingleFile(multipartFile, preSavePath, pathName);
            return MessageUtil.success(path, HttpStatus.OK);
        } catch (Throwable throwable) {
            LOG.error(MessageEnum.UPLOAD_FAILED.getMessage(), throwable);
            return MessageUtil.error(MessageEnum.UPLOAD_FAILED, throwable);
        }
    }
}
