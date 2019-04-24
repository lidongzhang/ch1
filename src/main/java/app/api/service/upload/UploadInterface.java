package app.api.service.upload;

import app.conf.ApiResponse.ResponseData;
import org.springframework.web.multipart.MultipartFile;

public interface UploadInterface {

    ResponseData uploadFile(MultipartFile file);
}
