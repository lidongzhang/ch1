package app.api.service.sysRight.impl;

import app.api.service.sysRight.DomainEnum;
import app.api.service.sysRight.SysRightInterface;
import app.mybatis.dao.Sys_right_controllerMapper;
import app.mybatis.dao.Sys_right_controller_methodMapper;
import app.mybatis.entity.Sys_right_controller;
import app.mybatis.entity.Sys_right_controllerExample;
import app.mybatis.entity.Sys_right_controller_method;
import app.mybatis.entity.Sys_right_controller_methodExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRightImpl implements SysRightInterface {

    @Resource
    Sys_right_controllerMapper sys_right_controllerMapper;
    @Resource
    Sys_right_controller_methodMapper sys_right_controller_methodMapper;

    @Override
    public  List<Controller> getClassMethod(){
        List<Controller> list = new ArrayList<>();
        Sys_right_controllerExample ce = new Sys_right_controllerExample();
        ce.setOrderByClause("sort");
        List<Sys_right_controller> sys_right_controllers = sys_right_controllerMapper.selectByExample(ce);
        for(Sys_right_controller sys_right_controller : sys_right_controllers){
            Controller c = new Controller();
            c.setId(sys_right_controller.getId());
            c.setName(sys_right_controller.getControllerClassName());
            c.setMatchUrl(sys_right_controller.getMatchUrl());
            c.setMemo(sys_right_controller.getMemo());
            c.setMenuUrl(sys_right_controller.getMenuUrl());
            c.setSort(sys_right_controller.getSort());
            c.setSysHas(sys_right_controller.getSysHas());
            c.setModel(sys_right_controller.getModel());
            c.setDomain(sys_right_controller.getDomain());
            c.setDomainDisplayName(getDomainDisplayByName(sys_right_controller.getDomain()));
            List<Method> ms = new ArrayList<>();
            c.setMethods(ms);
            list.add(c);

            Sys_right_controller_methodExample sys_right_controller_methodExample = new Sys_right_controller_methodExample();
            sys_right_controller_methodExample.setOrderByClause("sort");
            Sys_right_controller_methodExample.Criteria cm = sys_right_controller_methodExample.createCriteria();
            cm.andControllerIdEqualTo(sys_right_controller.getId());
            List<Sys_right_controller_method> sys_right_controller_methods = sys_right_controller_methodMapper.selectByExample(sys_right_controller_methodExample);
            for(Sys_right_controller_method sys_right_controller_method : sys_right_controller_methods){
                Method m = new Method();
                m.setId(sys_right_controller_method.getId());
                m.setName(sys_right_controller_method.getMethodName());
                m.setMatchUrl(sys_right_controller_method.getMatchUrl());
                m.setMemo(sys_right_controller_method.getMemo());
                m.setSort(sys_right_controller_method.getSort());
                m.setSysHas(sys_right_controller_method.getSysHas());
                m.setUrl(sys_right_controller_method.getUrl());
                ms.add(m);
            }
        }

        return list;
    }

    @Override
    public void setController(SetControllerParam param){
        Sys_right_controller sys_right_controller = new Sys_right_controller();
        sys_right_controller.setId(param.getId());
        sys_right_controller.setMatchUrl(param.getMatchUrl());
        sys_right_controller.setMemo(param.getMemo());
        sys_right_controller.setDomain(param.getDomain());
        sys_right_controller.setModel(param.getModel());

        sys_right_controllerMapper.updateByPrimaryKeySelective(sys_right_controller);
    }

    @Override
    public void changeControllerSort(Integer controllerId, Integer changeSort){
        Sys_right_controllerExample ce = new Sys_right_controllerExample();
        Sys_right_controllerExample.Criteria c = ce.createCriteria();
        c.andIdEqualTo(controllerId);
        List<Sys_right_controller> list = sys_right_controllerMapper.selectByExample(ce);
        Integer sort = list.get(0).getSort();
        ce.clear();
        c = ce.createCriteria();
        if(changeSort < 0) {
            c.andSortLessThan(sort);
            ce.setOrderByClause("sort desc");
        }
        if(changeSort > 0) {
            c.andSortGreaterThan(sort);
            ce.setOrderByClause("sort");
        }
        if(changeSort == 0) return;
        ce.setLimit(1);
        list = sys_right_controllerMapper.selectByExample(ce);
        if(list.size() == 0) return;
        Integer preId = list.get(0).getId();
        Integer preSort = list.get(0).getSort();
        Sys_right_controller controller = new Sys_right_controller();
        controller.setId(controllerId);
        controller.setSort(preSort);
        sys_right_controllerMapper.updateByPrimaryKeyChanged(controller);
        controller = new Sys_right_controller();
        controller.setId(preId);
        controller.setSort(sort);
        sys_right_controllerMapper.updateByPrimaryKeyChanged(controller);
    }

    @Override
    public void delController(Integer controllerid){
        Sys_right_controller_methodExample me = new Sys_right_controller_methodExample();
        Sys_right_controller_methodExample.Criteria mec = me.createCriteria();
        mec.andControllerIdEqualTo(controllerid);
        sys_right_controller_methodMapper.deleteByExample(me);
        sys_right_controllerMapper.deleteByPrimaryKey(controllerid);
    }

    @Override
    public void setControllerMethod(SetControllerMethodParam param){
        Sys_right_controller_method sys_right_controller_method = new Sys_right_controller_method();
        sys_right_controller_method.setId(param.getId());
        sys_right_controller_method.setMemo(param.getMemo());
        sys_right_controller_methodMapper.updateByPrimaryKeyChanged(sys_right_controller_method);
    }

    @Override
    public void changeControllerMethodSort(Integer controllerMethodId, Integer changeSort){

        Sys_right_controller_method sys_right_controller_method = sys_right_controller_methodMapper.selectByPrimaryKey(controllerMethodId);
        Integer sort = sys_right_controller_method.getSort();

        Sys_right_controller_methodExample me = new Sys_right_controller_methodExample();
        Sys_right_controller_methodExample.Criteria mec = me.createCriteria();
        if(changeSort < 0) {
            mec.andSortLessThan(sort);
            me.setOrderByClause("sort desc");
        }
        if(changeSort > 0) {
            mec.andSortGreaterThan(sort);
            me.setOrderByClause("sort");
        }
        if(changeSort == 0)
            return ;
        me.setLimit(1);

        List<Sys_right_controller_method> list = sys_right_controller_methodMapper.selectByExample(me);
        if(list.size() == 0) return;
        Integer preId = list.get(0).getId();
        Integer preSort = list.get(0).getSort();

        sys_right_controller_method  = new Sys_right_controller_method();
        sys_right_controller_method.setId(controllerMethodId);
        sys_right_controller_method.setSort(preSort);
        sys_right_controller_methodMapper.updateByPrimaryKeyChanged(sys_right_controller_method);

        sys_right_controller_method = new Sys_right_controller_method();
        sys_right_controller_method.setId(preId);
        sys_right_controller_method.setSort(sort);
        sys_right_controller_methodMapper.updateByPrimaryKeyChanged(sys_right_controller_method);

    }

    @Override
    public void delControllerMethod(Integer controllerMethodId){
        sys_right_controller_methodMapper.deleteByPrimaryKey(controllerMethodId);
    }

    @Override
    public List<Domain> getDomain(){
        List<Domain> list = new ArrayList<>();
        for(DomainEnum d : DomainEnum.values()){
            Domain domaim = new Domain();
            domaim.setDisplayName(d.getDisplayName());
            domaim.setName(d.toString());
            list.add(domaim);
        }
        return list;
    }

    private String getDomainDisplayByName(String name){
        String r = "";
        for(DomainEnum d : DomainEnum.values()){
            if(d.toString().equals(name))
                r = d.getDisplayName();
        }
        return r;
    }

}
