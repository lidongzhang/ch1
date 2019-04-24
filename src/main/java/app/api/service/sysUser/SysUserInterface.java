package app.api.service.sysUser;

import app.api.service.sysUser.impl.TokenAndUser;

public interface SysUserInterface {

    String getUserId();
    String getUserIdByUserToken(String userToken);
    TokenAndUser login(String nickName, String password);
    void logout();
    String getUserNickName();
    String getUserName();
}
