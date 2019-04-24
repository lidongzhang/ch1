package app.api.controller;

import app.api.service.sysUser.SysUserInterface;
import app.api.service.sysUser.impl.TokenAndUser;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping(value = "/api/sysUser")
public class    SysUserController {

    @Autowired
    SysUserInterface sysUserInterface;

    private static class LoginParam{
        private String nickName;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        private String password;

    }
    @RequestMapping("/login")
    public Response login(@RequestBody LoginParam loginParam){
        TokenAndUser tokenAndUser = sysUserInterface.login(loginParam.nickName, loginParam.password);
        if(tokenAndUser == null)
            return ResponseData.fail("用户名或密码错误!");
        else
            return ResponseData.success(tokenAndUser);
    }
}
