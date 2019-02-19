package app.conf;

import app.conf.ApiResponse.ApiResponse;
import app.conf.ApiResponse.Response;
import app.conf.ApiResponse.ResponseData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class AOPConfig {
    @Around("@within(org.springframework.stereotype.Controller) " +
            "&& execution(* app.api.controller.*.*(..))")
    public Response SimpleAop(final ProceedingJoinPoint pip) throws  Throwable {

        try{
            Object[] args = pip.getArgs();
            System.out .println ("args :" + Arrays.asList(args)) ;
            Object o = pip.proceed();
            System.out.println("return :" + o);
            return ApiResponse.success((ResponseData) o);
        }catch (Throwable e){

            //to do write log
            //throw e;
            return ApiResponse.fail("内部错误！");
        }

    }
}
