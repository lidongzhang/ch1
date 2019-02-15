package app.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class AppPropertiesConfig {

    @Autowired
    private Environment env ;

    @Bean
    public app.home.controller.AppProperties getAppPropertiesConfig(){
        return new app.home.controller.AppProperties(env);
    }
}
