package app.api.service.sys_right_group.impl;

import app.api.service.sys_right_group.Sys_right_groupInterface;

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
public class Sys_right_groupImpl implements Sys_right_groupInterface {

    @Autowired
    private AppProperties appProperties;

    @Resource
    private app.mybatis.dao.Sys_right_groupMapper sys_right_groupMapper;

    @Override
    public Response getByPrimaryKey(Long id){
        ResponseData r = Validation.checkId(id);
        if (r != null) return r;
        Integer lid = Integer.parseInt(id.toString());
        return ResponseData.success(sys_right_groupMapper.selectByPrimaryKey(lid));
    }

    @Override
    public Response updateByPrimaryKeyChanged(app.mybatis.entity.Sys_right_group sys_right_groupChanged){
        ResponseData r = checkData(sys_right_groupChanged);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;
        return ResponseData.success(sys_right_groupMapper.updateByPrimaryKeyChanged(sys_right_groupChanged));
    }

    @Override
    public Response insertChanged(app.mybatis.entity.Sys_right_group sys_right_groupChanged){
        ResponseData r = checkData(sys_right_groupChanged);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;

        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.MYSQL)
            sys_right_groupMapper.insertChanged(sys_right_groupChanged);
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.SQLSERVER)
            sys_right_groupMapper.insertSqlserverChanged(sys_right_groupChanged);

        //sys_right_groupMapper.insertChanged(sys_right_groupChanged);
        return ResponseData.success(sys_right_groupChanged.getId());
    }

    @Override
    public Response deleteByPrimaryKey(Long id){
        ResponseData r = Validation.checkId(id);
        if (r != null) return r;
        Integer lid = Integer.parseInt(id.toString());
        return ResponseData.success(sys_right_groupMapper.deleteByPrimaryKey(lid));
    }

    @Override
    public Response selectByMap(Map<String, Object> map)throws Exception{
        app.mybatis.entity.Sys_right_groupExample sys_right_groupExample = new app.mybatis.entity.Sys_right_groupExample();
        //add condition
        ResponseData r = checkSelectDataAddExample(map, sys_right_groupExample);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;
        return ResponseData.success(sys_right_groupMapper.selectByExample(sys_right_groupExample));
    }

    @Override
    public Response selectPageByMap(Map<String, Object> map)throws Exception{
        app.mybatis.entity.Sys_right_groupExample sys_right_groupExample = new app.mybatis.entity.Sys_right_groupExample();
        //add condition
        ResponseData r = checkSelectDataAddExample(map, sys_right_groupExample);
        if(r.getCode().equals(Response.CODE_FAIL)) return r;

//        Long count = sys_right_groupMapper.countByExample(sys_right_groupExample);
//        Integer limit = Integer.parseInt(map.get("limit").toString());
//        Integer offset = Page.getOffset(limit, Integer.parseInt(map.get("page").toString()));
//        sys_right_groupExample.setOffset(offset);
//        sys_right_groupExample.setLimit(limit);
//        Object data = sys_right_groupMapper.selectByExample(sys_right_groupExample);

        //page

        String orderBy = map.get("orderBy").toString();
        if(orderBy == null || orderBy.isEmpty())
        return ResponseData.fail("orderBy 参数必须设置");

        Long count = sys_right_groupMapper.countByExample(sys_right_groupExample);

        Integer limit = Integer.parseInt(map.get("limit").toString());//每页数据量
        Integer page = Integer.parseInt(map.get("page").toString());//页码的参数
        Integer offset = Page.getOffset(limit, page);

        Integer rowidStart = Page.getRowidStart(limit, page);
        Integer rowidEnd = Page.getRowidEnd(limit, page);

        Object data = null;
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.MYSQL) {
        sys_right_groupExample.setOffset(offset);
        sys_right_groupExample.setLimit(limit);
        data = sys_right_groupMapper.selectByExample(sys_right_groupExample);
        }
        if(appProperties.getDatabaseType() == AppProperties.DatabaseType.SQLSERVER){
        sys_right_groupExample.setOrderByClause(orderBy);
        sys_right_groupExample.setRowidStart(rowidStart);
        sys_right_groupExample.setRowidEnd(rowidEnd);
        data = sys_right_groupMapper.selectSqlserverByExample(sys_right_groupExample);
        }

        return ResponsePageData.success(data, count);
    }

    private ResponseData checkSelectDataAddExample(Map<String, Object> map, app.mybatis.entity.Sys_right_groupExample sys_right_groupExample)
        throws Exception
        {
        boolean b = true;
        ResponseData r ;
        StringBuilder sb = new StringBuilder();

        app.mybatis.entity.Sys_right_groupExample.Criteria c = sys_right_groupExample.createCriteria();

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
Object name = map.get("name");
r = Validation.check("name", DataTypeEnum.STRING, name, false, 0L, 200L, 0);
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
    private ResponseData checkData(app.mybatis.entity.Sys_right_group sys_right_groupChanged)
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
        if(sys_right_groupChanged.getId_changed()){
    r = Validation.check("id", DataTypeEnum.INT, sys_right_groupChanged.getId(),
            false, -2147483648L, 2147483647L, 0);
    if(r.getCode().equals(Response.CODE_FAIL)){
        b = false;
        sb.append(String.format("%s\r\n", r.getMsg()));
    }
}
if(sys_right_groupChanged.getName_changed()){
    r = Validation.check("name", DataTypeEnum.STRING, sys_right_groupChanged.getName(),
            false, 0L, 200L, 0);
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
