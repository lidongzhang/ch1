package app.api.controller;

import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/hello")
@ResponseBody
public class HelloController {

    @RequestMapping("/sayHello")
    public Response sayHello(){
        return ResponseData.success("api hello");
    }
}
