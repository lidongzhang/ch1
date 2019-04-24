package app.api.service.upload.impl;

import app.api.service.upload.UploadInterface;
import app.conf.ApiResponse.ResponseData;
import app.home.controller.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class UploadImpl  implements UploadInterface {

    @Autowired
    AppProperties appProperties;

    @Override
    public ResponseData uploadFile(MultipartFile file){
        if(file.isEmpty())
            return ResponseData.fail("没有文件");

        UUID uuid = UUID.randomUUID();
        String fileName = file.getOriginalFilename();
        String filePath = appProperties.getData_uploadTmp_path() + "/";
        File dest = new File(filePath + uuid);
        try {
            file.transferTo(dest);
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(fileName);
            fileEntity.setSaveFileName(uuid.toString());
            return ResponseData.success(fileEntity);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.toString());
            return ResponseData.fail("内部错误");
        }

    }
}
