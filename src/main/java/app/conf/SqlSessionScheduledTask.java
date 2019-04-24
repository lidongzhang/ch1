package app.conf;

import app.home.controller.AppProperties;
import app.mybatis.dao.Sys_ms_sessionMapper;
import app.mybatis.dao.Sys_my_sessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Configuration
@EnableScheduling
public class SqlSessionScheduledTask implements SchedulingConfigurer {

    @Autowired
    AppProperties appProperties;
    @Resource
    Sys_ms_sessionMapper sys_ms_sessionMapper;
    @Resource
    Sys_my_sessionMapper sys_my_sessionMapper;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addFixedRateTask(
                ()->{
                    cleanSessionDatabase();
                },
                appProperties.getSession_timeout() * 1000
        );
    }

    private void cleanSessionDatabase(){
        Integer timeout = appProperties.getSession_timeout();
        timeout = timeout * 1000;
        Date date =  new Date(new Date().getTime() - timeout);
        AppProperties.DatabaseType databaseType = appProperties.getDatabaseType();
        if(!(appProperties.getSession_type().equals("sql")))
            return;
        if(databaseType == AppProperties.DatabaseType.SQLSERVER){
            sys_ms_sessionMapper.clearTimeoutData(date);
        }
        if(databaseType == AppProperties.DatabaseType.MYSQL){
            sys_my_sessionMapper.clearTimeoutData(date);
        }
    }
}
