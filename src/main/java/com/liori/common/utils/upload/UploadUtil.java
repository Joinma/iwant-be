package com.liori.common.utils.upload;

import com.liori.common.exceptions.CustomizeServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadUtil {

    private final static Logger LOG = LoggerFactory.getLogger(UploadUtil.class);

    public static String uploadSingleFile(MultipartFile multipartFile, String preSavePath, String savePathName) {
        if (multipartFile.isEmpty()) {
            throw new CustomizeServiceException("请选择文件");
        }

        try {
            String pathName = preSavePath + savePathName;
            File file = new File(pathName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("保存文件时出现异常: \n" + e);
            throw new CustomizeServiceException("保存文件时出现异常");
        }
        return savePathName;
    }
}
