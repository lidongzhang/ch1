package app.api.controller;

import app.api.helper.session.SessionUtil;
import app.api.service.menu.MenuInterface;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuInterface  menuInterface;

    @RequestMapping("/getMenu")
    public Response getMenu(){
        return ResponseData.success(menuInterface.getMenus(""));
    }

}
