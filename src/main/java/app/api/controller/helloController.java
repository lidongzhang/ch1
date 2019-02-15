package app.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
@ResponseBody
public class helloController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "api hello";
    }
}
