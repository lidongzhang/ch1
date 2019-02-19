package app.api.service.user.impl;

import app.api.service.user.Result;
import app.api.service.user.UserInterface;
import app.conf.ApiResponse.ApiResponse;
import app.mybatis.dao.MyBatisUserDao;
import app.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl  implements UserInterface {

    @Autowired
    private MyBatisUserDao myBatisUserDao=null;

    @Override
    public User getUser(String id){
        return myBatisUserDao.getUser();
    }

    @Override
    public Result login(String nickName, String password){
        Result result = new Result();
        if(nickName.equals("admin")  && password.equals("1")){
            result.setCode(ApiResponse.CODE_SUCCESS);
            result.setToken("123456");
        }else {
            result.setCode(ApiResponse.CODE_FAIL);
            result.setMsg("用户名或密码错误！");
        }
        return result;
    }

    @Override
    public Boolean checkToken(String userToken){
        if ( userToken.equals("123456") )
            return true;
        else
            return false;
    }

    @Override
    public List<User> getUsers(Map<String, Object> param){
        User u = new User();
        u.setId(1L);
        u.setUserName("n1");
        List<User> list = new ArrayList<>();
        list.add(u);

        u = new User();
        u.setId(2L);
        u.setUserName("n2");
        list.add(u);

        return list;
    }
}
