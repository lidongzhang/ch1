package app.home.controller;

import org.springframework.core.env.Environment;

import java.util.Date;


public class AppProperties {

    private String base_url;
    private String base_sys_url;
    private String version;
    private String mode;
    private String log_path;
    private String data_path;

    public String getBase_sys_url() {
        return base_sys_url;
    }

    public void setBase_sys_url(String base_sys_url) {
        this.base_sys_url = base_sys_url;
    }



    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLog_path() {
        return log_path;
    }

    public void setLog_path(String log_path) {
        this.log_path = log_path;
    }

    public String getData_path() {
        return data_path;
    }

    public void setData_path(String data_path) {
        this.data_path = data_path;
    }

    public AppProperties(){}

    public AppProperties(Environment env){
        setMode(env.getProperty("app.mode"));
        setBase_url(env.getProperty("app.base-url"));
        setBase_sys_url(env.getProperty("app.base-sys-url"));
        setVersion(env.getProperty("app.version"));
        if(mode.equals("debug"))
            setVersion(version + "_debug_" + new Date().getTime());
        setData_path(env.getProperty("app.data-path"));
        setLog_path(env.getProperty("app.log-path"));
    }

}
