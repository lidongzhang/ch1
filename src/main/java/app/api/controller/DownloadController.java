package app.api.controller;

import app.api.service.download.DownloadFileInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("api/download")
public class DownloadController {

    @Autowired
    DownloadFileInterface downloadFileInterface;

    @RequestMapping("/file")
    public void file(String fileName , HttpServletRequest request, HttpServletResponse response){
        downloadFileInterface.down(fileName, request, response);
        //return ResponseData.success(null);
    }
}
