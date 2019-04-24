package app.api.service.sysUser.impl;

import app.api.helper.session.SessionFactory;
import app.api.helper.session.SessionInterface;
import app.api.service.sysUser.SysUserInterface;
import app.mybatis.dao.UsersMapper;
import app.mybatis.entity.Users;
import app.mybatis.entity.UsersExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Scope("prototype")
public class SysUserImpl implements SysUserInterface {

    @Autowired
    private SessionFactory sessionFactory;

    //region 无用
    public Boolean checkSessionByUserToken(String UserToken){
       if(getSessionByUserToken(UserToken) == null)
           return false;
       else
           return true;
    }
//    public Boolean checkSessionByUserId(String UserId){
//        if(getSessionByUserId(UserId) == null)
//            return false;
//        else
//            return true;
//    }

    public String getUserIdByHttpToken(){
        return sessionFactory.getUserIdByHttpToken();
    }

    public SessionInterface getSessionByUserToken(String UserToken){
        return sessionFactory.getSessionByUserToken(UserToken);
    }

//    public SessionInterface getSessionByUserId(String UserId){
//        return sessionFactory.getSessionByUserId(UserId);
//    }

    public void delSessionByUserToken(String UserToken){
        SessionInterface session = getSessionByUserToken(UserToken);
        sessionFactory.delSession(session);
    }
//    public void delSessionByUserId(String UserId){
//        SessionInterface session = getSessionByUserId(UserId);
//        sessionFactory.delSession(session);
//    }
    //endregion

    @Resource
    private UsersMapper usersMapper;

    @Override
    public TokenAndUser login(String nickName, String password){
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria c = usersExample.createCriteria();
        c.andNick_nameEqualTo(nickName);
        c.andPasswordEqualTo(password);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if(users.size() != 1)
            return null;
        Users user = users.get(0);
        String token = sessionFactory.getNewToken();
        SessionInterface session = sessionFactory.getAndCreateSessionByUserToken(token);
        session.setUserId(user.getId().toString());
        session.setUserNickName(user.getNick_name());
        session.setUserName(user.getName());
        TokenAndUser tokenAndUser = new TokenAndUser();
        tokenAndUser.setToken(token);
        User u = new User();
        u.setId(user.getId());
        u.setNickName(user.getNick_name());
        u.setName(user.getName());
        tokenAndUser.setUser(u);
        return tokenAndUser;
    }

    @Override
    public String getUserNickName(){
        SessionInterface session = sessionFactory.getSessionByHttpUserToken();
        if(session == null) return null;
        return session.getUserNickName();
    }

    @Override
    public String getUserId(){
        SessionInterface session = sessionFactory.getSessionByHttpUserToken();
        if(session == null) return null;
        return session.getUserId();
    }

    @Override
    public String getUserIdByUserToken(String userToken){
        SessionInterface session = sessionFactory.getSessionByUserToken(userToken);
        if(session == null) return  null;
        return session.getUserId();
    }

    @Override
    public String getUserName(){
        SessionInterface session = sessionFactory.getSessionByHttpUserToken();
        if(session == null) return null;
        return session.getUserName();
    }

    @Override
    public void logout(){
        SessionInterface session = sessionFactory.getSessionByHttpUserToken();
        sessionFactory.delSession(session);
    }

}
