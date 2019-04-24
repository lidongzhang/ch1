package app.api.helper.session;

import app.home.controller.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SessionFactory {

    @Autowired
    @Qualifier("sessionInterfaceConfig")
    private SessionInterface sessionInterface;

    public  String getUserIdByHttpToken(){
        SessionInterface session = getSessionByHttpUserToken();
        return session.getUserToken();
    }

    public  SessionInterface getAndCreateSessionByHttpUserToken(){
        String userToken = SessionUtil.getUserToken();
        return getAndCreateSessionByUserToken(userToken);
    }

    public  SessionInterface getAndCreateSessionByUserToken(String userToken){
        sessionInterface.init(userToken);
        return sessionInterface;
    }

    public  SessionInterface getAndCreateSessionByHttpTokenUserId(String userId){
        String token = SessionUtil.getUserToken();
        return getCreateSessionByUserId(token, userId);
    }

    public  SessionInterface getCreateSessionByUserId(String userToken, String userId){
        SessionInterface session = getSessionByUserToken(userToken);

        if(userToken == null)  userToken = getNewToken();
        if(session == null){
            sessionInterface.init(userToken);
            sessionInterface.setUserId(userId);
            return sessionInterface;
        }else {
            if(session.getUserId() == null){
                session.setUserId(userId);
                return session;
            }else
                return session;
        }
    }

    public  String getNewToken(){
        return UUID.randomUUID().toString();
    }

    public  SessionInterface getSessionByHttpUserToken(){
        String userToken = SessionUtil.getUserToken();
        if(userToken == null) return  null;
        if(sessionInterface.getSessionByUserToken(userToken))
            return sessionInterface;
        else
            return null;
    }

    public  SessionInterface getSessionByUserToken(String userToken){
        if(sessionInterface.getSessionByUserToken(userToken))
            return sessionInterface;
        else
            return null;
    }

//    public  SessionInterface getSessionByUserId(String userId){
//        if(sessionInterface.getSessionByUserId(userId))
//            return sessionInterface;
//        else
//            return null;
//    }

    public  void delSession(SessionInterface session){
        sessionInterface.delSession(sessionInterface);
    }

}
