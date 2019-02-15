package app.conf;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@Aspect
public class AOPConfig {
    @Around("@within(org.springframework.stereotype.Controller)")
    public Object SimpleAop(final ProceedingJoinPoint pip) throws  Throwable {
        try{
            Object[] args = pip.getArgs();
            System.out .println ("args :" + Arrays.asList(args)) ;
            Object o = pip.proceed();
            System.out.println("return :" + o);
            return o;
        }catch (Throwable e){
            throw e;
        }

    }
}
