package app.api.service.util;

import app.conf.ApiResponse.ResponseData;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validation {

    public static ResponseData checkId(Integer id) {
       return checkId(Long.parseLong(id.toString()));
    }

    public static ResponseData checkId(Long id){
        if(id == null) return ResponseData.fail("id不能为null");
        Long l = Validation.parseLong(id);
        if(l ==  null) return ResponseData.fail("id不是整数");

        return null;
    }

    public static ResponseData check(String name, DataTypeEnum type, Object value , boolean require, Long min , Long max, Integer scale){
        ResponseData ok = ResponseData.success(value);
        ResponseData errNull = ResponseData.fail(String.format("%s 必须有值,不能为null", name));
        ResponseData errEmpty = ResponseData.fail(String.format("%s 必须有值,不能为空", name));
        ResponseData errType = ResponseData.fail(String.format("%s 不是 %s 类型或超过精度", name, type.toString()));
        ResponseData errLtMin = ResponseData.fail(String.format("%s 值/字符数 %s 小于最小允许值 %s", name, value == null ? "" : value.toString(), min == null ? "" : min.toString()));
        ResponseData errGtMax = ResponseData.fail(String.format("%s 值/字符数 %s 大于最大允许值 %s", name, value == null ? "" : value.toString(), max == null ? "" : max.toString()));
        ResponseData errGtScale = ResponseData.fail(String.format("%s 值 %s 大于允许的精度 %s", name, value == null ? "" : value.toString(), scale == null ? "" : scale.toString()));

        if(value == null && !require)  return ok;
        if(value == null && require) return errNull;
        if(value.toString().isEmpty() && !require) return  ok;
        if(value.toString().trim().isEmpty() && require) return errEmpty;

        switch (type){
            case LONGINT:
                Long l = parseLong(value);
                if(l == null) return errType;
                if(l < min) return errLtMin;
                if(l > max) return errGtMax;
                return ok;
            case INT:
                Integer i = parseInt(value);
                if(i == null) return  errType;
                if(i < min) return errLtMin;
                if(i > max) return errGtMax;
                return ok;
            case STRING:
                String s = value.toString();
                if(s.length() < min) return errLtMin;
                if(s.length() > max) return errGtMax;
                return ok;
            case TIME:
            case DATETIME:
            case DATE:
                Date d = parseTime(value);
                if(d == null) return  errType;
                return ok;
            case DECIMAL:
                BigDecimal bg = parseDecimal(value);
                if(bg == null) return  errType;
                if(bg.compareTo(BigDecimal.valueOf(min)) < 0 ) return errLtMin;
                if(bg.compareTo(BigDecimal.valueOf(max)) > 0 ) return errGtMax;
                if(bg.scale() > scale) return errGtScale;
                return ok;
            case BOOLEAN:
                Boolean b = parseBoolean(value);
                if(b == null) return errType;
                return ok;

        }

        return ResponseData.success(null);
    }

    public static  Long parseLong(Object value){

       try {
         return   Long.parseLong(value.toString());
       }catch (Exception e){
           return null;
       }
    }

    public static  Integer parseInt(Object value){

        try {
            return   Integer.parseInt(value.toString());
        }catch (Exception e){
            return null;
        }
    }

    public static Date parseTime(Object value){
        try{
            if(value instanceof Date)
                return (Date) value;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            return simpleDateFormat.parse(value.toString());
        }catch (Exception e){
            return null;
        }
    }

    public static BigDecimal parseDecimal(Object value){
        try{
            return new BigDecimal(value.toString());
        }catch (Exception e){
            return null;
        }
    }

    public static Boolean parseBoolean(Object value){
        try{
            return Boolean.parseBoolean(value.toString());
        }catch (Exception e){
            return null;
        }
    }
}
