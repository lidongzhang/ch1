package app.api.controller;

import app.api.service.menu.MenuInterface;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/menu")
@ResponseBody
public class MenuController {

    @Autowired
    private MenuInterface  menuInterface;

    @RequestMapping("/getMenu")
    public Response getMenu(){

        return ResponseData.success(menuInterface.getMenus(""));
    }

}
