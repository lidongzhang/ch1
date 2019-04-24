package app.conf;

import app.api.helper.session.MysqlSession;
import app.api.helper.session.RedisSession;
import app.api.helper.session.SessionInterface;
import app.api.helper.session.SqlserverSession;
import app.home.controller.AppProperties;
import app.mybatis.dao.Sys_ms_session_objectMapper;
import app.mybatis.dao.Sys_ms_sessionMapper;
import app.mybatis.dao.Sys_my_sessionMapper;
import app.mybatis.dao.Sys_my_session_objectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Slf4j
@Configuration
public class SessionConfig {

    @Autowired
    private AppProperties appProperties;
    @Autowired
    private RedisSession redisSession;
    @Autowired
    private MysqlSession mysqlSession;
    @Autowired
    private SqlserverSession sqlserverSession;

    @Resource
    private Sys_ms_session_objectMapper sys_ms_session_objectMapper;
    @Resource
    private Sys_ms_sessionMapper sys_ms_sessionMapper;
    @Resource
    private Sys_my_sessionMapper sys_my_sessionMapper;
    @Resource
    private Sys_my_session_objectMapper sys_my_session_objectMapper;


    @Bean("sessionInterfaceConfig")
    public SessionInterface session(){
        String sessionType = appProperties.getSession_type();
        if(sessionType.equals("redis")){
            return redisSession;
        }
        if(sessionType.equals("sql")) {
            AppProperties.DatabaseType databaseType = appProperties.getDatabaseType();
            if(databaseType == AppProperties.DatabaseType.SQLSERVER) {
                int c = sys_ms_sessionMapper.selectTableCount();
                if (c == 0)
                    sys_ms_sessionMapper.createTable();
                c = sys_ms_session_objectMapper.selectTableCount();
                if (c == 0)
                    sys_ms_session_objectMapper.createTable();
                return sqlserverSession;
            }
            if(databaseType == AppProperties.DatabaseType.MYSQL){
                int c = sys_my_sessionMapper.selectTableCount();
                if (c == 0)
                    sys_my_sessionMapper.createTable();
                c = sys_my_session_objectMapper.selectTableCount();
                if (c == 0)
                    sys_my_session_objectMapper.createTable();

                return mysqlSession;
            }
            return null;
        }
        return null;
    }



}
