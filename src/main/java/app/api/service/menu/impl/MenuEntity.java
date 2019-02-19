package app.api.service.menu.impl;

import java.util.List;

public class MenuEntity {
    private String title;
    private String icon;
    private String href;
    private Boolean spread;
    private String right;
    private List<MenuEntity> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }
    //反序列化的时候，不能正确识别true false 为boolean，所以增加此set函数
    public void setSpread(String spread){
        if (spread.equals("true"))
            this.spread = true;
        else
            this.spread = false;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public List<MenuEntity> getChildren() {
        return children;
    }

    public void setChildren(List<MenuEntity> children) {
        this.children = children;
    }

}
