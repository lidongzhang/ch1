package app.api.controller;

import app.api.service.sys_right_group.Sys_right_groupInterface;
import app.mybatis.entity.Sys_right_group;

import app.conf.ApiResponse.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Scope("prototype")
@RequestMapping(value = "/api/sys_right_group")
public class Sys_right_groupController {

    @Autowired
    private Sys_right_groupInterface sys_right_groupInterface;

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
        return sys_right_groupInterface.getByPrimaryKey(param.getId());
    }

    @RequestMapping("/updateByPrimaryKeyChanged")
    public Response updateByPrimaryKeyChanged(@RequestBody Sys_right_group sys_right_groupChanged){
        return sys_right_groupInterface.updateByPrimaryKeyChanged(sys_right_groupChanged);
    }

    @RequestMapping("/insertChanged")
    public Response insertChanged(@RequestBody Sys_right_group sys_right_groupChanged){
        return sys_right_groupInterface.insertChanged(sys_right_groupChanged);
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
        return sys_right_groupInterface.deleteByPrimaryKey(param.getId());
    }

    @RequestMapping("/selectPageByMap")
    public Response selectPageByMap(@RequestBody Map<String,Object> map) throws  Exception{
        return sys_right_groupInterface.selectPageByMap(map);
    }
}
