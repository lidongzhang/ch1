package app.api.service.sys_right_group_detail.impl;

import app.api.service.sys_right_group_detail.Sys_right_group_detailInterface;

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
public class Sys_right_group_detailImpl implements Sys_right_group_detailInterface {

    @Autowired
    private AppProperties appProperties;

    @Resource
    private app.mybatis.dao.Sys_right_group_detailMapper sys_right_group_detailMapper;

    @Override
    public Response getByPrimaryKey(Long id){
        ResponseData r = Validation.checkId(id);
        if (r != null) return r;
        Integer lid = Integer.parseInt(id.toString());
        return ResponseData.success(sys_right_group_detailMapper.selectByPrimaryKey(lid));
    }

    @Override
    public Response updateByPrimaryKeyChanged(app.mybatis.entity.Sys_right_group_detail sys_right_group_detailChanged){
        ResponseData r = checkData(sys_right_group_detailChanged);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;
        return ResponseData.success(sys_right_group_detailMapper.updateByPrimaryKeyChanged(sys_right_group_detailChanged));
    }

    @Override
    public Response insertChanged(app.mybatis.entity.Sys_right_group_detail sys_right_group_detailChanged){
        ResponseData r = checkData(sys_right_group_detailChanged);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;

        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.MYSQL)
            sys_right_group_detailMapper.insertChanged(sys_right_group_detailChanged);
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.SQLSERVER)
            sys_right_group_detailMapper.insertSqlserverChanged(sys_right_group_detailChanged);

        //sys_right_group_detailMapper.insertChanged(sys_right_group_detailChanged);
        return ResponseData.success(sys_right_group_detailChanged.getId());
    }

    @Override
    public Response deleteByPrimaryKey(Long id){
        ResponseData r = Validation.checkId(id);
        if (r != null) return r;
        Integer lid = Integer.parseInt(id.toString());
        return ResponseData.success(sys_right_group_detailMapper.deleteByPrimaryKey(lid));
    }

    @Override
    public Response selectByMap(Map<String, Object> map)throws Exception{
        app.mybatis.entity.Sys_right_group_detailExample sys_right_group_detailExample = new app.mybatis.entity.Sys_right_group_detailExample();
        //add condition
        ResponseData r = checkSelectDataAddExample(map, sys_right_group_detailExample);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;
        return ResponseData.success(sys_right_group_detailMapper.selectByExample(sys_right_group_detailExample));
    }

    @Override
    public Response selectPageByMap(Map<String, Object> map)throws Exception{
        app.mybatis.entity.Sys_right_group_detailExample sys_right_group_detailExample = new app.mybatis.entity.Sys_right_group_detailExample();
        //add condition
        ResponseData r = checkSelectDataAddExample(map, sys_right_group_detailExample);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;

//        Long count = sys_right_group_detailMapper.countByExample(sys_right_group_detailExample);
//        Integer limit = Integer.parseInt(map.get("limit").toString());
//        Integer offset = Page.getOffset(limit, Integer.parseInt(map.get("page").toString()));
//        sys_right_group_detailExample.setOffset(offset);
//        sys_right_group_detailExample.setLimit(limit);
//        Object data = sys_right_group_detailMapper.selectByExample(sys_right_group_detailExample);

        //page

        String orderBy = map.get("orderBy").toString();
        if(orderBy == null || orderBy.isEmpty())
        return ResponseData.fail("orderBy 参数必须设置");

        Long count = sys_right_group_detailMapper.countByExample(sys_right_group_detailExample);

        Integer limit = Integer.parseInt(map.get("limit").toString());//每页数据量
        Integer page = Integer.parseInt(map.get("page").toString());//页码的参数
        Integer offset = Page.getOffset(limit, page);

        Integer rowidStart = Page.getRowidStart(limit, page);
        Integer rowidEnd = Page.getRowidEnd(limit, page);

        Object data = null;
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.MYSQL) {
        sys_right_group_detailExample.setOffset(offset);
        sys_right_group_detailExample.setLimit(limit);
        data = sys_right_group_detailMapper.selectByExample(sys_right_group_detailExample);
        }
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.SQLSERVER){
        sys_right_group_detailExample.setOrderByClause(orderBy);
        sys_right_group_detailExample.setRowidStart(rowidStart);
        sys_right_group_detailExample.setRowidEnd(rowidEnd);
        data = sys_right_group_detailMapper.selectSqlserverByExample(sys_right_group_detailExample);
        }

        return ResponsePageData.success(data, count);
    }

    private ResponseData checkSelectDataAddExample(Map<String, Object> map, app.mybatis.entity.Sys_right_group_detailExample sys_right_group_detailExample)
        throws Exception
        {
        boolean b = true;
        ResponseData r ;
        StringBuilder sb = new StringBuilder();

        app.mybatis.entity.Sys_right_group_detailExample.Criteria c = sys_right_group_detailExample.createCriteria();

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
Object groupId = map.get("groupId");
r = Validation.check("groupId", DataTypeEnum.INT, groupId, false, -2147483648L, 2147483647L, 0);
if(r.getCode().equals(Response.CODE_FAIL)){
    b = false;
    sb.append(r.getMsg());
}else{
    if(groupId != null && !(groupId.toString().isEmpty()) )
        c.andGroupIdEqualTo(Integer.parseInt(groupId.toString()));
}
Object methodId = map.get("methodId");
r = Validation.check("methodId", DataTypeEnum.INT, methodId, false, -2147483648L, 2147483647L, 0);
if(r.getCode().equals(Response.CODE_FAIL)){
    b = false;
    sb.append(r.getMsg());
}else{
    if(methodId != null && !(methodId.toString().isEmpty()) )
        c.andMethodIdEqualTo(Integer.parseInt(methodId.toString()));
}

        if(!b)
            return ResponseData.fail(sb.toString());

        return ResponseData.success("");
    }

    //region checkData
    private ResponseData checkData(app.mybatis.entity.Sys_right_group_detail sys_right_group_detailChanged)
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
        if(sys_right_group_detailChanged.getId_changed()){
    r = Validation.check("id", DataTypeEnum.INT, sys_right_group_detailChanged.getId(),
            false, -2147483648L, 2147483647L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}
if(sys_right_group_detailChanged.getGroupId_changed()){
    r = Validation.check("groupId", DataTypeEnum.INT, sys_right_group_detailChanged.getGroupId(),
            false, -2147483648L, 2147483647L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}
if(sys_right_group_detailChanged.getMethodId_changed()){
    r = Validation.check("methodId", DataTypeEnum.INT, sys_right_group_detailChanged.getMethodId(),
            false, -2147483648L, 2147483647L, 0);
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
