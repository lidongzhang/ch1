package app.api.controller;

import app.api.service.users.UsersInterface;
import app.mybatis.entity.Users;

import app.conf.ApiResponse.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping(value = "/api/users")
public class UsersController {

    @Autowired
    private UsersInterface usersInterface;

    private static class GetByPrimaryKeyParam{
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        private Long id;
    }
    @RequestMapping("/getByPrimaryKey")
    public Response getByPrimaryKey(@RequestBody GetByPrimaryKeyParam param){
        return usersInterface.getByPrimaryKey(param.getId());
    }

    @RequestMapping("/updateByPrimaryKeyChanged")
    public Response updateByPrimaryKeyChanged(@RequestBody Users usersChanged){
        return usersInterface.updateByPrimaryKeyChanged(usersChanged);
    }

    @RequestMapping("/insertChanged")
    public Response insertChanged(@RequestBody Users usersChanged){
        return usersInterface.insertChanged(usersChanged);
    }

    private static class DeleteByPrimaryKeyParam{
        private Long id;
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
    @RequestMapping("/deleteByPrimaryKey")
    public Response deleteByPrimaryKey(@RequestBody DeleteByPrimaryKeyParam param){
        return usersInterface.deleteByPrimaryKey(param.getId());
    }

    @RequestMapping("/selectPageByMap")
    public Response selectPageByMap(@RequestBody Map<String,Object> map) throws  Exception{
        return usersInterface.selectPageByMap(map);
    }
}
