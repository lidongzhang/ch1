package app.api.service.sys_right_group_detail;

import app.conf.ApiResponse.Response;
import java.util.Map;

public interface Sys_right_group_detailInterface {

    //selectByPrimaryKey
    Response getByPrimaryKey(Long id);

    //updateChanged
    Response updateByPrimaryKeyChanged(app.mybatis.entity.Sys_right_group_detail sys_right_group_detailChanged);

    //insertChanged
    Response insertChanged(app.mybatis.entity.Sys_right_group_detail sys_right_group_detailChanged);

    //deleteByPrimaryKey
    Response deleteByPrimaryKey(Long id);

    //selectByExample
    Response selectByMap(Map<String, Object> map)throws Exception;

    Response selectPageByMap(Map<String, Object> map)throws Exception;

}
