package app.api.service.user;

import app.mybatis.entity.User;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;

public interface UserInterface {
     User getUser(String id);
     Result login(String nickName, String password);
     Boolean checkToken(String userToken);
     List<User> getUsers(Map<String, Object> param);
}
