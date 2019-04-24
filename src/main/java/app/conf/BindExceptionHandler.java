package app.conf;

import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//@RestControllerAdvice
//public class BindExceptionHandler {
//
//    @ExceptionHandler(BindException.class)
//    public Response handleBindException(BindException ex) {
//        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
//        FieldError fieldError = ex.getFieldError();
//        StringBuilder sb = new StringBuilder();
//        //sb.append(fieldError.getField()).append("=[").append(fieldError.getRejectedValue()).append("]")
//        //        .append(fieldError.getDefaultMessage());
//        sb.append(fieldError.getDefaultMessage());
//        // 生成返回结果
//        return ResponseData.fail(sb.toString());
//    }
//}