package app.api.service.sys_right_group;

import app.conf.ApiResponse.Response;
import java.util.Map;

public interface Sys_right_groupInterface {

    //selectByPrimaryKey
    Response getByPrimaryKey(Long id);

    //updateChanged
    Response updateByPrimaryKeyChanged(app.mybatis.entity.Sys_right_group sys_right_groupChanged);

    //insertChanged
    Response insertChanged(app.mybatis.entity.Sys_right_group sys_right_groupChanged);

    //deleteByPrimaryKey
    Response deleteByPrimaryKey(Long id);

    //selectByExample
    Response selectByMap(Map<String, Object> map)throws Exception;

    Response selectPageByMap(Map<String, Object> map)throws Exception;

}
