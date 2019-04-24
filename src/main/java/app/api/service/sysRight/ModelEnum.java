package app.api.service.sysRight;

public enum ModelEnum {
    EVERYONE("所有人"), ASSIGN("指定人员");

    private String displayName;

    ModelEnum(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
