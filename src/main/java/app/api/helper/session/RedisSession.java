package app.api.helper.session;

import app.api.helper.RedisUtil;
import app.home.controller.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RedisSession implements SessionInterface {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private AppProperties appProperties;
    private String prefix = "session";
    private String useridfix = "userid";
    private String tokenfix = "token";
    private String userId;
    private String userToken;

    public  boolean getSessionByUserToken(String userToken){

        if( _getValue(String.format("%s_%s_%s:%s", prefix, tokenfix, userToken, "token")) == null)
            return false;
        else {
             init(userToken);
             return true;
        }
    }

    public  boolean getSessionByUserId(String userId) {
        String userToken = _getValue(String.format("%s_%s_%s:%s", prefix, useridfix ,userId, "token" )).toString();
        if( userToken == null)
            return false;
        init(userToken);
        setUserId(userId);
        return true;
    }

    public  void delSession(SessionInterface sessionInterface){
        sessionInterface.delAllData();
        sessionInterface = null;
    }

    public RedisSession(){

    }

    @Override
    public void init(String userToken){
        this.userToken = userToken;
        if(getUserToken() == null)
            setUserToken(userToken);
        else
            this.userId = getUserId();
    }

    @Override
    public void setUserToken(String userToken){
        this.userToken = userToken;
        _setValue(getTokenKeyName("token"), userToken);

    }
    @Override
    public String getUserToken(){
        Object obj = _getValue(getTokenKeyName("token"));
        if(obj == null)
            return null;
        else
            obj.toString();
        return  null;
    }

    //region userId
    @Override
    public void setUserId(String userId){

        this.userId = userId;
        _setValue(getTokenKeyName("id"), userId);
        //_setValue(getUserIdKeyName("token"), userToken);
    }
    @Override
    public String getUserId(){
        return _getValue(getTokenKeyName("id")).toString();
    }

    @Override
    public void delUserId(){
        redisUtil.del(getTokenKeyName("id"));
        //redisUtil.del(getUserIdKeyName("token"));
        userId = null;
    }
    //endregion

    //region userName
    @Override
    public void setUserName(String userName){
        _setValue(getTokenKeyName("name"), userId);
    }
    @Override
    public String getUserName(){
        return _getValue(getTokenKeyName("name")).toString();
    }
    @Override
    public void delUserName(){
        redisUtil.del(getTokenKeyName("name"));
    }
    //endregion

    //region nickName
    @Override
    public void setUserNickName(String nickName){
        _setValue(getTokenKeyName("nickname"), nickName);
    }
    @Override
    public String getUserNickName(){
        return _getValue(getTokenKeyName("nickname")).toString();
    }
    //endregion

    //region value
    @Override
    public <T> void  setValue(String name ,T value){
        _setValue(getTokenKeyName(name), value);
    }
    @Override
    public <T> T getValue(String name, Class<T> type){
        return (T)(_getValue(getTokenKeyName("name")));
    }
    @Override
    public void delValue(String name){
        redisUtil.del(getTokenKeyName("name"));
    }
    //endregion

    @Override
    public void delAllData(){
        Set<String> sets = redisUtil.keys(String.format("%s*", getTokenKeyNamePrefix()));
        for(String key : sets){
            redisUtil.del(key);
        }
        sets = redisUtil.keys(String.format("%s*", getUserIdKeyNamePrefix()));
        for(String key : sets){
            redisUtil.del(key);
        }
    }

    //region set get
    private void _setValue(String key, Object value){
        redisUtil.set(key, value);
        _refreshExpire();
    }
    private Object _getValue(String key){
        _refreshExpire();
        return redisUtil.get(key);
    }
    private void _refreshExpire(){
        Integer timeout = appProperties.getSession_timeout();
        Set<String> sets = redisUtil.keys(String.format("%s*", getTokenKeyNamePrefix()));
        for(String key : sets){
            redisUtil.expire(key, timeout);
        }
        sets = redisUtil.keys(String.format("%s*", getUserIdKeyNamePrefix()));
        for(String key : sets){
            redisUtil.expire(key, timeout);
        }
    }
    //endregion

    private  String getTokenKeyName(String name){
        return String.format("%s_%s_%s:%s", prefix, tokenfix ,userToken, name);
    }

    private String getTokenKeyNamePrefix(){
        return String.format("%s_%s_%s:", prefix, tokenfix ,userToken);
    }

    private String getUserIdKeyName(String name){
        return String.format("%s_%s_%s:%s", prefix, useridfix ,userId, name);
    }
    private String getUserIdKeyNamePrefix(){
        return String.format("%s_%s_%s:", prefix, useridfix ,userId);
    }
}
