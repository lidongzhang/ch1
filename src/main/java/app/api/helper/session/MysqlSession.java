package app.api.helper.session;

import app.mybatis.dao.Sys_my_sessionMapper;
import app.mybatis.dao.Sys_my_session_objectMapper;
import app.mybatis.entity.Sys_my_session;
import app.mybatis.entity.Sys_my_sessionExample;
import app.mybatis.entity.Sys_my_session_object;
import app.mybatis.entity.Sys_my_session_objectExample;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MysqlSession implements SessionInterface {

    @Resource
    private Sys_my_session_objectMapper sys_my_session_objectMapper;
    @Resource
    private Sys_my_sessionMapper sys_my_sessionMapper;

    private String userId;
    private String userToken;

    public MysqlSession(){}

    @Override
    public  boolean getSessionByUserToken(String userToken){
        Sys_my_sessionExample sys_my_sessionExample = new Sys_my_sessionExample();
        Sys_my_sessionExample.Criteria c = sys_my_sessionExample.createCriteria();
        c.andTokenEqualTo(userToken);
        long count = sys_my_sessionMapper.countByExample(sys_my_sessionExample);
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
            Sys_my_session sys_my_session = new Sys_my_session();
            sys_my_session.setToken(userToken);
            sys_my_session.setLastOperDatetime(new Date());
            sys_my_sessionMapper.insertChanged(sys_my_session);
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
        Sys_my_sessionExample sys_ms_sessionExample = new Sys_my_sessionExample();
        Sys_my_sessionExample.Criteria c = sys_ms_sessionExample.createCriteria();
        c.andTokenEqualTo(this.userToken);
        long count = sys_my_sessionMapper.countByExample(sys_ms_sessionExample);
        if(count == 0  )
            return null;
        return userToken;
    }
    //endregion

    @Override
    public void delAllData(){
        String token = this.userToken;
        sys_my_session_objectMapper.deleteByToken(token);
        sys_my_sessionMapper.deleteByToken(token);
    }

    private Integer getId(){
        Sys_my_sessionExample sys_my_sessionExample = new Sys_my_sessionExample();
        Integer id = null;
        Sys_my_sessionExample.Criteria c = sys_my_sessionExample.createCriteria();
        c.andTokenEqualTo(this.userToken);
        List<Sys_my_session> rs = sys_my_sessionMapper.selectByExample(sys_my_sessionExample);
        if(rs.size() == 0 )
            id = null;
        else
            id = rs.get(0).getId();
        return id;
    }

    //region userid
    @Override
    public void setUserId(String userId){
        _refreshExpire();
        this.userId = userId;
        Sys_my_session sys_my_session = new Sys_my_session();
        Integer id = getId();
        sys_my_session.setId(id);
        sys_my_session.setToken(this.userToken);
        sys_my_session.setUserId(this.userId);
        sys_my_sessionMapper.updateByPrimaryKeyChanged(sys_my_session);
    }
    @Override
    public String getUserId(){
        _refreshExpire();
        Sys_my_sessionExample sys_my_sessionExample = new Sys_my_sessionExample();
        Sys_my_sessionExample.Criteria c = sys_my_sessionExample.createCriteria();
        c.andTokenEqualTo(this.userToken);
        List<Sys_my_session> rs = sys_my_sessionMapper.selectByExample(sys_my_sessionExample);
        if(rs.size() == 0 ) return null;
        return  rs.get(0).getUserId();
    }

    @Override
    public void delUserId(){
        _refreshExpire();
        Sys_my_session sys_my_session = new Sys_my_session();
        Integer id = getId();
        sys_my_session.setId(id);
        sys_my_session.setUserId(null);
        sys_my_sessionMapper.updateByPrimaryKeyChanged(sys_my_session);
    }
    //endregion

    //region userName
    @Override
    public void setUserName(String userName){
        _refreshExpire();
        Sys_my_session sys_my_session = new Sys_my_session();
        Integer id = getId();
        sys_my_session.setId(id);
        sys_my_session.setUserName(userName);
        sys_my_sessionMapper.updateByPrimaryKeyChanged(sys_my_session);
    }

    @Override
    public String getUserName(){
        _refreshExpire();
        Integer id = getId();
        Sys_my_session sys_my_session = sys_my_sessionMapper.selectByPrimaryKey(id);
        return  sys_my_session.getUserName();
    }
    @Override
    public void delUserName(){
        _refreshExpire();
        Sys_my_session sys_my_session = new Sys_my_session();
        Integer id = getId();
        sys_my_session.setId(id);
        sys_my_session.setUserName(null);
        sys_my_sessionMapper.updateByPrimaryKeyChanged(sys_my_session);
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

        Sys_my_session_object sys_my_session_object = new Sys_my_session_object();
        sys_my_session_object.setKeyName(name);
        sys_my_session_object.setToken(userToken);
        sys_my_session_object.setKeyValue(s);
        sys_my_session_objectMapper.insertSqlserverChanged(sys_my_session_object);
    }
    @Override
    public <T> T getValue(String name, Class<T> type){
        _refreshExpire();
        Sys_my_session_objectExample sys_my_session_objectExample = new Sys_my_session_objectExample();
        Sys_my_session_objectExample.Criteria c = sys_my_session_objectExample.createCriteria();
        c.andTokenEqualTo(userToken);
        c.andKeyNameEqualTo(name);
        List<Sys_my_session_object> rs = sys_my_session_objectMapper.selectByExample(sys_my_session_objectExample);
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
        Sys_my_session_objectExample sys_my_session_objectExample = new Sys_my_session_objectExample();
        Sys_my_session_objectExample.Criteria c = sys_my_session_objectExample.createCriteria();
        c.andTokenEqualTo(userToken);
        c.andKeyNameEqualTo(name);
        sys_my_session_objectMapper.deleteByExample(sys_my_session_objectExample);
    }
    //endregion

    //region nickName
    @Override
    public void setUserNickName(String nickName){
        _refreshExpire();
        Integer id = getId();
        Sys_my_session sys_my_session = new Sys_my_session();
        sys_my_session.setId(id);
        sys_my_session.setUserNickName(nickName);
        sys_my_sessionMapper.updateByPrimaryKeyChanged(sys_my_session);
    }
    @Override
    public String getUserNickName(){
        _refreshExpire();
        Sys_my_sessionExample sys_my_sessionExample = new Sys_my_sessionExample();
        Sys_my_sessionExample.Criteria c = sys_my_sessionExample.createCriteria();
        c.andTokenEqualTo(userToken);
        List<Sys_my_session> rs = sys_my_sessionMapper.selectByExample(sys_my_sessionExample);
        return rs.get(0).getUserNickName();
    }
    //endregion

    private void _refreshExpire(){
        Sys_my_sessionExample sys_my_sessionExample = new Sys_my_sessionExample();
        Sys_my_sessionExample.Criteria c = sys_my_sessionExample.createCriteria();
        c.andTokenEqualTo(userToken);

        Sys_my_session sys_my_session = new Sys_my_session();
        sys_my_session.setLastOperDatetime(new Date());
        sys_my_sessionMapper.updateByExampleSelective(sys_my_session, sys_my_sessionExample);

    }
}
