package app.api.helper.session;

import app.mybatis.dao.Sys_ms_session_objectMapper;
import app.mybatis.dao.Sys_ms_sessionMapper;
import app.mybatis.entity.Sys_ms_session_object;
import app.mybatis.entity.Sys_ms_session_objectExample;
import app.mybatis.entity.Sys_ms_session;
import app.mybatis.entity.Sys_ms_sessionExample;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class SqlserverSession implements SessionInterface {

    @Resource
    private Sys_ms_session_objectMapper sys_ms_session_objectMapper;
    @Resource
    private Sys_ms_sessionMapper sys_ms_sessionMapper;

    private String userId;
    private String userToken;

    public SqlserverSession(){}

    @Override
    public  boolean getSessionByUserToken(String userToken){
        Sys_ms_sessionExample sys_ms_sessionExample = new Sys_ms_sessionExample();
        Sys_ms_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(userToken);
        long count = sys_ms_sessionMapper.countByExample(sys_ms_sessionExample);
        if(count == 1) {
            init(userToken);
            return true;
        }
        return false;
    }
//    @Override
//    public boolean getSessionByUserId(String usrId){
//        return false;
//    }
    @Override
    public  void delSession(SessionInterface sessionInterface){
        sessionInterface.delAllData();
        sessionInterface = null;
    }
    @Override
    public void init(String userToken){
        this.userToken = userToken;
        if(getUserToken() == null) {
            Sys_ms_session sys_ms_session = new Sys_ms_session();
            sys_ms_session.setToken(userToken);
            sys_ms_session.setLastOperDatetime(new Date());
            sys_ms_sessionMapper.insertSqlserverChanged(sys_ms_session);
        }
        else {
            _refreshExpire();
            this.userId = getUserId();
        }
    }

    //region token
    @Override
    public void setUserToken(String userToken){
        //无需操作，因为设置就是增加，修改没有意义
        _refreshExpire();
    }

    @Override
    public String getUserToken(){
        _refreshExpire();
        Sys_ms_sessionExample sys_ms_sessionExample = new Sys_ms_sessionExample();
        Sys_ms_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(this.userToken);
        long count = sys_ms_sessionMapper.countByExample(sys_ms_sessionExample);
        if(count == 0  )
            return null;
        return userToken;
    }
    //endregion

    @Override
    public void delAllData(){
        String token = this.userToken;
        sys_ms_session_objectMapper.deleteByToken(token);
        sys_ms_sessionMapper.deleteByToken(token);
    }

    //region userid
    @Override
    public void setUserId(String userId){
        _refreshExpire();
        this.userId = userId;
        Sys_ms_session sys_ms_session = new Sys_ms_session();
        Integer id = getId();
        sys_ms_session.setId(id);
        sys_ms_session.setToken(this.userToken);
        sys_ms_session.setUserId(this.userId);
        sys_ms_sessionMapper.updateByPrimaryKeyChanged(sys_ms_session);
    }
    @Override
    public String getUserId(){
        _refreshExpire();
        Sys_ms_sessionExample sys_ms_sessionExample = new Sys_ms_sessionExample();
        Sys_ms_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(this.userToken);
        List<Sys_ms_session> rs = sys_ms_sessionMapper.selectByExample(sys_ms_sessionExample);
        if(rs.size() == 0 ) return null;
        return  rs.get(0).getUserId();
    }

    @Override
    public void delUserId(){
        _refreshExpire();
        Sys_ms_session sys_ms_session = new Sys_ms_session();
        Integer id = getId();
        sys_ms_session.setId(id);
        sys_ms_session.setUserId(null);
        sys_ms_sessionMapper.updateByPrimaryKeyChanged(sys_ms_session);
    }
    //endregion

    private Integer getId(){
        Sys_ms_sessionExample sys_ms_sessionExample = new Sys_ms_sessionExample();
        Integer id = null;
        Sys_ms_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(this.userToken);
        List<Sys_ms_session> rs = sys_ms_sessionMapper.selectByExample(sys_ms_sessionExample);
        if(rs.size() == 0 )
            id = null;
        else
            id = rs.get(0).getId();
        return id;
    }

    //region userName
    @Override
    public void setUserName(String userName){
        _refreshExpire();
        Sys_ms_session sys_ms_session = new Sys_ms_session();
        Integer id = getId();
        sys_ms_session.setId(id);
        sys_ms_session.setUserName(userName);
        sys_ms_sessionMapper.updateByPrimaryKeyChanged(sys_ms_session);
    }

    @Override
    public String getUserName(){
        _refreshExpire();
        Integer id = getId();
        Sys_ms_session sys_ms_session = sys_ms_sessionMapper.selectByPrimaryKey(id);
        return  sys_ms_session.getUserName();
    }
    @Override
    public void delUserName(){
        _refreshExpire();
        Sys_ms_session sys_ms_session = new Sys_ms_session();
        Integer id = getId();
        sys_ms_session.setId(id);
        sys_ms_session.setUserName(null);
        sys_ms_sessionMapper.updateByPrimaryKeyChanged(sys_ms_session);
    }
    //endregion

    //region value
    @Override
    public <T> void  setValue(String name ,T value){
        _refreshExpire();
        ObjectMapper objectMapper = new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.toString());
        }
        delValue(name);

        Sys_ms_session_object sys_ms_session_object = new Sys_ms_session_object();
        sys_ms_session_object.setKeyName(name);
        sys_ms_session_object.setToken(userToken);
        sys_ms_session_object.setKeyValue(s);
        sys_ms_session_objectMapper.insertSqlserverChanged(sys_ms_session_object);

    }
    @Override
    public <T> T getValue(String name, Class<T> type){
        _refreshExpire();
        Sys_ms_session_objectExample sys_ms_session_objectExample = new Sys_ms_session_objectExample();
        Sys_ms_session_objectExample.Criteria c = sys_ms_session_objectExample.createCriteria();
        c.andTokenEqualTo(userToken);
        c.andKeyNameEqualTo(name);
        List<Sys_ms_session_object> rs = sys_ms_session_objectMapper.selectByExample(sys_ms_session_objectExample);
        String s = rs.get(0).getKeyValue();
        Object value = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            value = objectMapper.readValue(s, TypeFactory.rawClass(type));
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.toString());
        }

        return (T) value;
    }

    @Override
    public void delValue(String name){
        _refreshExpire();
        Sys_ms_session_objectExample sys_ms_session_objectExample = new Sys_ms_session_objectExample();
        Sys_ms_session_objectExample.Criteria c = sys_ms_session_objectExample.createCriteria();
        c.andTokenEqualTo(userToken);
        c.andKeyNameEqualTo(name);
        sys_ms_session_objectMapper.deleteByExample(sys_ms_session_objectExample);
    }
    //endregion

    //region nickName
    @Override
    public void setUserNickName(String nickName){
        _refreshExpire();
        Integer id = getId();
        Sys_ms_session sys_ms_session = new Sys_ms_session();
        sys_ms_session.setId(id);
        sys_ms_session.setUserNickName(nickName);
        sys_ms_sessionMapper.updateByPrimaryKeyChanged(sys_ms_session);
    }
    @Override
    public String getUserNickName(){
        _refreshExpire();
        Sys_ms_sessionExample sys_ms_sessionExample = new Sys_ms_sessionExample();
        Sys_ms_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(userToken);
        List<Sys_ms_session> rs = sys_ms_sessionMapper.selectByExample(sys_ms_sessionExample);
        return rs.get(0).getUserNickName();
    }
    //endregion

    private void _refreshExpire(){
        Sys_ms_sessionExample sys_ms_sessionExample = new Sys_ms_sessionExample();
        Sys_ms_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(userToken);
        Sys_ms_session sys_ms_session = new Sys_ms_session();
        sys_ms_session.setLastOperDatetime(new Date());
        sys_ms_sessionMapper.updateByExampleSelective(sys_ms_session, sys_ms_sessionExample);
    }
}
