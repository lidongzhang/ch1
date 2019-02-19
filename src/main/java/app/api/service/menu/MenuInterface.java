package app.api.service.menu;

import app.api.service.menu.impl.MenuEntity;

import java.util.List;

public interface MenuInterface {

    List<MenuEntity> getMenus(String right);

}
