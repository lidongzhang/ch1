package app.api.controller;

import app.conf.ApiResponse.ApiResponse;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("api")
public class ErrorController {

    @RequestMapping("/apiError")
    public Response error(@RequestAttribute(name="app-error-msg") String[] app_error_msg){
        String msg = "其他错误";
        if (app_error_msg != null &&
            app_error_msg.length >0 &&
            !app_error_msg[0].equals(""))
            msg = app_error_msg[0];
        return ResponseData.fail(msg);
    }
}
