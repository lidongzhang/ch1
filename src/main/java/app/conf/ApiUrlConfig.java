package app.conf;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ApiUrlConfig {

    @Bean
    public ServletRegistrationBean restServlet(){
        //注解扫描上下文
        AnnotationConfigWebApplicationContext applicationContext
                = new AnnotationConfigWebApplicationContext();
        //base package
        applicationContext.scan("com.bee.sample.ch1.api.controller");
        //通过构造函数指定dispatcherServlet的上下文
        DispatcherServlet rest_dispatcherServlet
                = new DispatcherServlet(applicationContext);

        //用ServletRegistrationBean包装servlet
        ServletRegistrationBean registrationBean
                = new ServletRegistrationBean(rest_dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        //指定urlmapping
        registrationBean.addUrlMappings("/api/*");
        //指定name，如果不指定默认为dispatcherServlet
        registrationBean.setName("api"); //冲掉默认dispatcherServlet
        return registrationBean;
    }

//    @Bean
//    public ServletRegistrationBean resourceServlet() {
//        DispatcherServlet dispatcherServlet = new DispatcherServlet();
//        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
//        dispatcherServlet.setApplicationContext(applicationContext);
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
//        servletRegistrationBean.addUrlMappings("*.htm","*.html","*.css", "*.js", "*.ttf", "*.png", "*.jpg", "*.gif", "*.woff", "*.woff2");
//        servletRegistrationBean.setLoadOnStartup(1);
//
//        servletRegistrationBean.setName("resource");
//        return servletRegistrationBean;
//    }
}
