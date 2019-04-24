package app.api.service.users.impl;

import app.api.service.users.UsersInterface;

import app.api.service.util.DataTypeEnum;
import app.api.service.util.Page;
import app.api.service.util.Validation;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import app.conf.ApiResponse.ResponsePageData;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Map;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import app.home.controller.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Scope("prototype")
public class UsersImpl implements UsersInterface {

    @Autowired
    private AppProperties appProperties;

    @Resource
    private app.mybatis.dao.UsersMapper usersMapper;

    @Override
    public Response getByPrimaryKey(Long id){
        ResponseData r = Validation.checkId(id);
        if (r != null) return r;
        Integer lid = Integer.parseInt(id.toString());
        return ResponseData.success(usersMapper.selectByPrimaryKey(lid));
    }

    @Override
    public Response updateByPrimaryKeyChanged(app.mybatis.entity.Users usersChanged){
        ResponseData r = checkData(usersChanged);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;
        return ResponseData.success(usersMapper.updateByPrimaryKeyChanged(usersChanged));
    }

    @Override
    public Response insertChanged(app.mybatis.entity.Users usersChanged){
        ResponseData r = checkData(usersChanged);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;

        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.MYSQL)
            usersMapper.insertChanged(usersChanged);
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.SQLSERVER)
            usersMapper.insertSqlserverChanged(usersChanged);

        //usersMapper.insertChanged(usersChanged);
        return ResponseData.success(usersChanged.getId());
    }

    @Override
    public Response deleteByPrimaryKey(Long id){
        ResponseData r = Validation.checkId(id);
        if (r != null) return r;
        Integer lid = Integer.parseInt(id.toString());
        return ResponseData.success(usersMapper.deleteByPrimaryKey(lid));
    }

    @Override
    public Response selectByMap(Map<String, Object> map)throws Exception{
        app.mybatis.entity.UsersExample usersExample = new app.mybatis.entity.UsersExample();
        //add condition
        ResponseData r = checkSelectDataAddExample(map, usersExample);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;
        return ResponseData.success(usersMapper.selectByExample(usersExample));
    }

    @Override
    public Response selectPageByMap(Map<String, Object> map)throws Exception{
        app.mybatis.entity.UsersExample usersExample = new app.mybatis.entity.UsersExample();
        //add condition
        ResponseData r = checkSelectDataAddExample(map, usersExample);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;

//        Long count = usersMapper.countByExample(usersExample);
//        Integer limit = Integer.parseInt(map.get("limit").toString());
//        Integer offset = Page.getOffset(limit, Integer.parseInt(map.get("page").toString()));
//        usersExample.setOffset(offset);
//        usersExample.setLimit(limit);
//        Object data = usersMapper.selectByExample(usersExample);

        //page

        String orderBy = map.get("orderBy").toString();
        if(orderBy == null || orderBy.isEmpty())
        return ResponseData.fail("orderBy 参数必须设置");

        Long count = usersMapper.countByExample(usersExample);

        Integer limit = Integer.parseInt(map.get("limit").toString());//每页数据量
        Integer page = Integer.parseInt(map.get("page").toString());//页码的参数
        Integer offset = Page.getOffset(limit, page);

        Integer rowidStart = Page.getRowidStart(limit, page);
        Integer rowidEnd = Page.getRowidEnd(limit, page);

        Object data = null;
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.MYSQL) {
        usersExample.setOffset(offset);
        usersExample.setLimit(limit);
        data = usersMapper.selectByExample(usersExample);
        }
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.SQLSERVER){
        usersExample.setOrderByClause(orderBy);
        usersExample.setRowidStart(rowidStart);
        usersExample.setRowidEnd(rowidEnd);
        data = usersMapper.selectSqlserverByExample(usersExample);
        }

        return ResponsePageData.success(data, count);
    }

    private ResponseData checkSelectDataAddExample(Map<String, Object> map, app.mybatis.entity.UsersExample usersExample)
        throws Exception
        {
        boolean b = true;
        ResponseData r ;
        StringBuilder sb = new StringBuilder();

        app.mybatis.entity.UsersExample.Criteria c = usersExample.createCriteria();

//        Object c1 = map.get("c1");
//        r = Validation.check("c1", DataTypeEnum.STRING, c1, false, 0L, 100L, 0);
//        if(r.getCode().equals(Response.CODE_FAIL)){
//            b = false;
//            sb.append(r.getMsg());
//        }else{
//            if(c1 != null && !(c1.toString().isEmpty()) )
//                c.andC1Like(String.format("%%%s%%", c1.toString()));
//        }
//
//        Object c2 = map.get("c2");
//        r = Validation.check("c2", DataTypeEnum.INT, c2, false, 0L, 100L, 0);
//        if(r.getCode().equals(Response.CODE_FAIL)){
//            b = false;
//            sb.append(String.format("/r/n%s", r.getMsg()));
//        }else{
//            if(c2 != null && !c2.toString().isEmpty())
//                c.andC2EqualTo(Integer.parseInt(c2.toString()));
//        }
        Object id = map.get("id");
r = Validation.check("id", DataTypeEnum.INT, id, false, -2147483648L, 2147483647L, 0);
if(r.getCode().equals(Response.CODE_FAIL)){
    b = false;
    sb.append(r.getMsg());
}else{
    if(id != null && !(id.toString().isEmpty()) )
        c.andIdEqualTo(Integer.parseInt(id.toString()));
}
Object nick_name = map.get("nick_name");
r = Validation.check("nick_name", DataTypeEnum.STRING, nick_name, false, 0L, 50L, 0);
if(r.getCode().equals(Response.CODE_FAIL)){
    b = false;
    sb.append(r.getMsg());
}else{
    if(nick_name != null && !(nick_name.toString().isEmpty()) )
        c.andNick_nameLike(String.format("%%%s%%", nick_name.toString()));
}
Object password = map.get("password");
r = Validation.check("password", DataTypeEnum.STRING, password, false, 0L, 50L, 0);
if(r.getCode().equals(Response.CODE_FAIL)){
    b = false;
    sb.append(r.getMsg());
}else{
    if(password != null && !(password.toString().isEmpty()) )
        c.andPasswordLike(String.format("%%%s%%", password.toString()));
}
Object name = map.get("name");
r = Validation.check("name", DataTypeEnum.STRING, name, false, 0L, 50L, 0);
if(r.getCode().equals(Response.CODE_FAIL)){
    b = false;
    sb.append(r.getMsg());
}else{
    if(name != null && !(name.toString().isEmpty()) )
        c.andNameLike(String.format("%%%s%%", name.toString()));
}

        if(!b)
            return ResponseData.fail(sb.toString());

        return ResponseData.success("");
    }

    //region checkData
    private ResponseData checkData(app.mybatis.entity.Users usersChanged)
        {

        StringBuilder sb = new StringBuilder();
        ResponseData r;
        boolean b = true;

//        if(t1Changed.getC1_changed()){
//            r = Validation.check("c1", DataTypeEnum.STRING, t1Changed.getC1(),
//                    true, 1L,10L, 0);
//            if(r.getCode().equals(Response.CODE_FAIL)){
//                b = false;
//                sb.append(String.format("%s\r\n", r.getMsg()));
//            }
//        }
//        if(t1Changed.getC2_changed()){
//            r = Validation.check("c1", DataTypeEnum.STRING, t1Changed.getC2(),
//                    true, 1L,10L, 0);
//            if(r.getCode().equals(Response.CODE_FAIL)){
//                b = false;
//                sb.append(String.format("%s\r\n", r.getMsg()));
//            }
//        }
        if(usersChanged.getId_changed()){
    r = Validation.check("id", DataTypeEnum.INT, usersChanged.getId(),
            false, -2147483648L, 2147483647L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}
if(usersChanged.getNick_name_changed()){
    r = Validation.check("nick_name", DataTypeEnum.STRING, usersChanged.getNick_name(),
            true, 0L, 50L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}
if(usersChanged.getPassword_changed()){
    r = Validation.check("password", DataTypeEnum.STRING, usersChanged.getPassword(),
            false, 0L, 50L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}
if(usersChanged.getName_changed()){
    r = Validation.check("name", DataTypeEnum.STRING, usersChanged.getName(),
            true, 0L, 50L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}

        if(!b)
            return ResponseData.fail(sb.toString());
        else
            return ResponseData.success(null);
    }
    //endregion

}
