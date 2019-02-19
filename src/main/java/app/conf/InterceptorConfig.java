package app.conf;

import app.api.lnterceptor.ApiInterceptor;
import app.api.service.user.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private Environment env;

    @Autowired
    private UserInterface userInterface;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器到 Spring MVC机制， 然后它会返回一个拦截器注册
        ApiInterceptor apiInterceptor = new ApiInterceptor(env, userInterface);

        InterceptorRegistration ir = registry.addInterceptor(apiInterceptor);
        //指定拦截匹配模式，限制拦截器拦截请求
        ir.addPathPatterns ("/api/**");

    }
}
