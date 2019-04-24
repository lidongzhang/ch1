package app.conf;

import app.api.service.sysRight.RightUtil;
import app.api.service.sysRight.UrlMethodEntiry;
import app.mybatis.dao.Sys_right_controllerMapper;
import app.mybatis.dao.Sys_right_controller_methodMapper;
import app.mybatis.entity.Sys_right_controller;
import app.mybatis.entity.Sys_right_controllerExample;
import app.mybatis.entity.Sys_right_controller_method;
import app.mybatis.entity.Sys_right_controller_methodExample;
import app.mybatisEx.dao.Sys_right_controllerExMapper;
import app.mybatisEx.dao.Sys_right_controller_methodExMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class SysRightConfig {

    @Resource
    Sys_right_controllerMapper sys_right_controllerMapper;
    @Resource
    Sys_right_controller_methodMapper sys_right_controller_methodMapper;
    @Resource
    Sys_right_controllerExMapper sys_right_controllerExMapper;
    @Resource
    Sys_right_controller_methodExMapper sys_right_controller_methodExMapper;

    @Autowired
    RightUtil rightUtil;

    @Bean
    public void sysRightDatabaseSet(){
        Map<String, List<UrlMethodEntiry>> urlClassMethod = rightUtil.getUrlClassMethod();
        List<Integer> listId = new ArrayList();
        List<Integer> listMethodId = new ArrayList<>();
        for(String controllerName : urlClassMethod.keySet()){
            Long controllerId = controllerSet(controllerName);
            listId.add(controllerId.intValue());
            List<UrlMethodEntiry> list = urlClassMethod.get(controllerName);
            for(UrlMethodEntiry entiry: list){
                Long methodId = methodSet(controllerId, entiry);
                listMethodId.add(methodId.intValue());
            }
        }

        //系统中没有的controller在数据库中设置 sysHas = false
        Sys_right_controllerExample sys_right_controllerExample = new Sys_right_controllerExample();
        Sys_right_controllerExample.Criteria c = sys_right_controllerExample.createCriteria();
        c.andIdNotIn(listId);
        Sys_right_controller sys_right_controller = new Sys_right_controller();
        sys_right_controller.setSysHas(false);
        sys_right_controllerMapper.updateByExampleSelective(sys_right_controller, sys_right_controllerExample);
        //系统中没有的controllerMethod在数据库中设置 sysHas = false
        Sys_right_controller_methodExample sys_right_controller_methodExample = new Sys_right_controller_methodExample();
        Sys_right_controller_methodExample.Criteria cm = sys_right_controller_methodExample.createCriteria();
        cm.andIdNotIn(listMethodId);
        Sys_right_controller_method sys_right_controller_method = new Sys_right_controller_method();
        sys_right_controller_method.setSysHas(false);
        sys_right_controller_methodMapper.updateByExampleSelective(sys_right_controller_method, sys_right_controller_methodExample);
        //设置 sort
        sys_right_controllerExMapper.updateSortFromId();
        sys_right_controller_methodExMapper.updateSortFromId();
    }

    private long controllerSet(String controllerName){
        Sys_right_controllerExample sys_right_controllerExample = new Sys_right_controllerExample();
        Sys_right_controllerExample.Criteria c = sys_right_controllerExample.createCriteria();
        c.andControllerClassNameEqualTo(controllerName);
        List<Sys_right_controller>  list = sys_right_controllerMapper.selectByExample(sys_right_controllerExample);
        if(list.size() == 0 ){
            Sys_right_controller sys_right_controller = new Sys_right_controller();
            sys_right_controller.setControllerClassName(controllerName);
            sys_right_controller.setSysHas(true);
            sys_right_controller.setModel("ASSIGN");
            long id = sys_right_controllerMapper.insertChanged(sys_right_controller);
            return  id;
        }else{
            Sys_right_controller sys_right_controller = new Sys_right_controller();
            Integer id = list.get(0).getId();
            sys_right_controller.setId(id.intValue());
            sys_right_controller.setSysHas(true);
            sys_right_controllerMapper.updateByPrimaryKeyChanged(sys_right_controller);
            return id.longValue();
        }
    }

    private long methodSet(Long controllerId,UrlMethodEntiry methodEntiry){
        Sys_right_controller_methodExample sys_right_controller_methodExample = new Sys_right_controller_methodExample();
        Sys_right_controller_methodExample.Criteria c = sys_right_controller_methodExample.createCriteria();
        c.andControllerIdEqualTo(controllerId.intValue());
        c.andMethodNameEqualTo(methodEntiry.getMethodName());
        List<Sys_right_controller_method> list = sys_right_controller_methodMapper.selectByExample(sys_right_controller_methodExample);
        if(list.size() == 0){
            Sys_right_controller_method sys_right_controller_method = new Sys_right_controller_method();
            sys_right_controller_method.setMethodName(methodEntiry.getMethodName());
            sys_right_controller_method.setUrl(methodEntiry.getUrl());
            sys_right_controller_method.setSysHas(true);
            sys_right_controller_method.setControllerId(controllerId.intValue());
            return sys_right_controller_methodMapper.insertChanged(sys_right_controller_method);
        }else{
            Integer id =  list.get(0).getId();
            Sys_right_controller_method sys_right_controller_method = new Sys_right_controller_method();
            sys_right_controller_method.setId(id);
            sys_right_controller_method.setSysHas(true);
            sys_right_controller_methodMapper.updateByPrimaryKeyChanged(sys_right_controller_method);
            return id;
        }
    }


}
