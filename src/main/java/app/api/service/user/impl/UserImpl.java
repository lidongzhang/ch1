package app.api.service.user.impl;

import app.api.service.user.UserInterface;
import app.mybatis.dao.MyBatisUserDao;
import app.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl  implements UserInterface {

    @Autowired
    private MyBatisUserDao myBatisUserDao=null;

    @Override
    public User getUser(){
        return myBatisUserDao.getUser();
    }
}
