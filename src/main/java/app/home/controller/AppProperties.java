package app.home.controller;

import org.springframework.core.env.Environment;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;


public class AppProperties {

    private String base_url;
    private String base_sys_url;
    private String version;
    private String mode;
    private String log_path;
    private String data_path;
    private String data_uploadTmp_path;
    private String api_login_url;
    private String api_error_url;
    private String error_url;
    private String api_upload_url;
    private String api_download_url;
    private String layui_version;

    private String spring_datasource_url;
    private String session_type;
    private Integer session_timeout;

    public Integer getSession_timeout() {
        return session_timeout;
    }

    public void setSession_timeout(Integer session_timeout) {
        this.session_timeout = session_timeout;
    }


    public String getSession_type() {
        return session_type;
    }

    public void setSession_type(String session_type) {
        this.session_type = session_type;
    }

    public String getLayui_version() {
        return layui_version;
    }

    public void setLayui_version(String layui_version) {
        this.layui_version = layui_version;
    }

    public String getApi_login_url() {
        return api_login_url;
    }

    public void setApi_login_url(String api_login_url) {
        this.api_login_url = api_login_url;
    }

    public String getApi_error_url() {
        return api_error_url;
    }

    public void setApi_error_url(String api_error_url) {
        this.api_error_url = api_error_url;
    }

    public String getError_url() {
        return error_url;
    }

    public void setError_url(String error_url) {
        this.error_url = error_url;
    }

    public String getApi_upload_url() {
        return api_upload_url;
    }

    public void setApi_upload_url(String api_upload_url) {
        this.api_upload_url = api_upload_url;
    }

    public String getApi_download_url() {
        return api_download_url;
    }

    public void setApi_download_url(String api_download_url) {
        this.api_download_url = api_download_url;
    }



    public String getData_uploadTmp_path() {
        return data_uploadTmp_path;
    }

    public void setData_uploadTmp_path(String data_uploadTmp_path) {
        this.data_uploadTmp_path = data_uploadTmp_path;
    }

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

    public AppProperties() {
    }

    public AppProperties(Environment env) {
        setMode(env.getProperty("app.mode"));
        setBase_url(env.getProperty("app.base-url"));
        setBase_sys_url(env.getProperty("app.base-sys-url"));
        setVersion(env.getProperty("app.version"));
        if (mode.equals("debug"))
            setVersion(version + "_debug_" + new Date().getTime());
        setData_path(env.getProperty("app.data-path"));
        setLog_path(env.getProperty("app.log-path"));
        setData_uploadTmp_path(env.getProperty("app.data-uploadTmp-path"));

        setApi_login_url(env.getProperty("app.api-login-url"));
        setApi_error_url(env.getProperty("app.api-error-url"));
        setError_url(env.getProperty("app.error-url"));
        setApi_upload_url(env.getProperty("app.api-upload-url"));
        setApi_download_url(env.getProperty("app.api-download-url"));

        setLayui_version(env.getProperty("app.layui-version"));
        setSession_type(env.getProperty("app.session.type"));
        setSession_timeout(Integer.parseInt(env.getProperty("app.session.timeout")));

        spring_datasource_url = env.getProperty("spring.datasource.url");

    }

    public enum DatabaseType  { MYSQL, SQLSERVER, NONE }
    public DatabaseType getDatabaseType(){

        if(spring_datasource_url == null || spring_datasource_url.isEmpty())
            return DatabaseType.NONE;

        String t = spring_datasource_url.replaceFirst(" ", "");
        if(t.indexOf(":mysql:") > 0 )
            return DatabaseType.MYSQL;
        if(t.indexOf(":sqlserver:") > 0)
            return DatabaseType.SQLSERVER;

        return DatabaseType.NONE;
    }
}