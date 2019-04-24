package app.api.service.sysRight;

public enum DomainEnum {
    GUEST("访客"), USER("用户"), MANAGE("管理"), SYS("系统");

    private String displayName;

    DomainEnum(String displayName){
        this.displayName = displayName;
    }

    public  String getDisplayName(){
        return  this.displayName;
    }

}
