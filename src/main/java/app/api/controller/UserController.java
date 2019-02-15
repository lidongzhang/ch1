package app.api.controller;

import app.api.service.user.UserInterface;
import app.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
@ResponseBody
public class UserController {
    @Autowired
    private UserInterface userInterface = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        return userInterface.getUser();

    }
}
