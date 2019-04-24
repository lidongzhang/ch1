package app.api.controller;

import app.api.service.upload.UploadInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import app.conf.ApiResponse.Response;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload")
@ResponseBody
public class uploadController {

    @Autowired
    UploadInterface uploadInterface;

    @RequestMapping("/file")
    public Response file(MultipartFile file, String user_token){
//        if( !userInterface.checkToken(user_token))
//            return ResponseData.fail("没有用户身份");
        return uploadInterface.uploadFile(file);
    }
}
