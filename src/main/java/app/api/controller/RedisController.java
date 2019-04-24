package app.api.controller;

import app.api.helper.RedisUtil;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="api/redis")
@ResponseBody
public class RedisController {

    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/test")
    public Response test(){
//        User user =  new User();
//        user.setUserName("n1-中文");
//        user.setId(1L);
//
//        redisUtil.set("key-test", user);

        return ResponseData.success(redisUtil.get("key-test"));
    }

}
