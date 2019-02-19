package app.api.controller;

import app.api.service.user.Result;
import app.api.service.user.UserInterface;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import app.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/api/user")
@ResponseBody
public class UserController {
    @Autowired
    private UserInterface userInterface = null;

    @RequestMapping("/getUser")
    public User getUser(){
        return userInterface.getUser("");

    }

    @RequestMapping(value = "/login")
    public Response login(String nickName, String password){
        Result result = userInterface.login(nickName, password);

        return new ResponseData(result.getCode(),
                result.getMsg(),
                result
                );
    }

    @RequestMapping("/getUsers")
    public Response getUsers(@RequestBody Map<String, Object> param){

        List<User> list = userInterface.getUsers(param);
        return new ResponseData(list);
    }
}
