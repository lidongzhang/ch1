package app.api.helper.session;

public interface SessionInterface {

    void init(String userToken);

    boolean getSessionByUserToken(String userToken);
    //boolean getSessionByUserId(String usrId);
    void delSession(SessionInterface sessionInterface);

    void setUserToken(String userToken);
    String getUserToken();
    void delAllData();

    void setUserId(String userId);
    String getUserId();
    void delUserId();

    void setUserName(String userName);
    String getUserName();
    void delUserName();

    void setUserNickName(String nickName);
    String getUserNickName();

    <T> void  setValue(String name ,T value);
    <T> T getValue(String name, Class<T> type);
    void delValue(String name);

}
