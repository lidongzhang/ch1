package app.api.service.sysUser.impl;

public class TokenAndUser {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String token;
    private User user;


}
