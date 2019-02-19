package app.api.controller;

import app.conf.ApiResponse.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import app.conf.ApiResponse.Response;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload")
@ResponseBody
public class uploadController {

    @RequestMapping("/file")
    public Response file(MultipartFile file){
        String fileName = file.getOriginalFilename();
        return ResponseData.success(null);
    }
}
