package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@SpringBootApplication
@MapperScan({"app.mybatis.dao", "app.mybatisEx.dao"})
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class, args);

    }

}
