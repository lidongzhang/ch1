package app.api.controller;

import java.util.List;
import app.api.service.sysRight.SysRightInterface;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping(value = "/api/sysRight")
public class SysRightController {
    @Autowired
    private SysRightInterface sysRightInterface;

    @RequestMapping(value = "/getClassMethod")
    public Response getClassMethod() {
        List<SysRightInterface.Controller> m = sysRightInterface.getClassMethod();
        return ResponseData.success(m);
    }

    //region controller
    @RequestMapping(value="/setController")
    public Response setController(@RequestBody SysRightInterface.SetControllerParam param){
        sysRightInterface.setController(param);
        return ResponseData.success(null);
    }

    private static class ChangeControllerSortParam{
        private Integer id;
        private Integer changeSort;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getChangeSort() {
            return changeSort;
        }

        public void setChangeSort(Integer changeSort) {
            this.changeSort = changeSort;
        }

    }
    @RequestMapping(value="/changeControllerSort")
    public Response changeControllerSort(@RequestBody ChangeControllerSortParam param){
        sysRightInterface.changeControllerSort(param.getId(), param.getChangeSort());
        return ResponseData.success(null);
    }

    private static class DelControllerParam{
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
    @RequestMapping(value="/delController")
    public Response delController(@RequestBody DelControllerParam param){
        sysRightInterface.delController(param.getId());
        return ResponseData.success(null);
    }
    //endregion

    //region controllerMethod
    @RequestMapping(value="/setControllerMethod")
    public Response setControllerMethod(@RequestBody SysRightInterface.SetControllerMethodParam param){
        sysRightInterface.setControllerMethod(param);
        return ResponseData.success(null);
    }

    private static class ChangeControllerMethodSortParam{
        private Integer id;
        private Integer changeSort;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getChangeSort() {
            return changeSort;
        }

        public void setChangeSort(Integer changeSort) {
            this.changeSort = changeSort;
        }

    }
    @RequestMapping(value="/changeControllerMethodSort")
    public Response changeControllerMethodSort(@RequestBody ChangeControllerMethodSortParam param){
        sysRightInterface.changeControllerMethodSort(param.getId(), param.getChangeSort());
        return ResponseData.success(null);
    }

    private static class DelControllerMethodParam{
        private Integer id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
    @RequestMapping(value="/delControllerMethod")
    public Response delControllerMethod(@RequestBody DelControllerMethodParam param){
        sysRightInterface.delControllerMethod(param.getId());
        return ResponseData.success(null);
    }

    //endregion

    @RequestMapping(value="/getDomain")
    public Response getDomain(){
        return ResponseData.success(sysRightInterface.getDomain());
    }
}
