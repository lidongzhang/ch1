package app.api.service.users;

import app.conf.ApiResponse.Response;
import java.util.Map;

public interface UsersInterface {

    //selectByPrimaryKey
    Response getByPrimaryKey(Long id);

    //updateChanged
    Response updateByPrimaryKeyChanged(app.mybatis.entity.Users usersChanged);

    //insertChanged
    Response insertChanged(app.mybatis.entity.Users usersChanged);

    //deleteByPrimaryKey
    Response deleteByPrimaryKey(Long id);

    //selectByExample
    Response selectByMap(Map<String, Object> map)throws Exception;

    Response selectPageByMap(Map<String, Object> map)throws Exception;

}
