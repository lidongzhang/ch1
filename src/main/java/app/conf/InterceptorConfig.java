package app.conf;

import app.api.lnterceptor.ApiInterceptor;
import app.api.service.sysUser.SysUserInterface;
import app.home.controller.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private AppProperties appProperties;

    @Autowired
    private SysUserInterface sysUserInterface;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器到 Spring MVC机制， 然后它会返回一个拦截器注册
        ApiInterceptor apiInterceptor = new ApiInterceptor(appProperties, sysUserInterface);

        InterceptorRegistration ir = registry.addInterceptor(apiInterceptor);
        //指定拦截匹配模式，限制拦截器拦截请求
        ir.addPathPatterns ("/api/**");

    }
}
