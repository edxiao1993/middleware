package org.kevin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.kevin.annotation.MyLogger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Aspect
@Component
public class AnnotationAOP {
    @Pointcut("@annotation(org.kevin.annotation.MyLogger)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object aroundCut(ProceedingJoinPoint pjp){
        try{
            this.displayLog(pjp);
            return pjp.proceed();
        } catch (Throwable throwable){
            throwable.printStackTrace();
            return null;
        }
    }

    private void displayLog(ProceedingJoinPoint pjp){
        MethodSignature signature = (MethodSignature) pjp.getSignature();

        Method method = signature.getMethod();
        MyLogger myLogger = method.getAnnotation(MyLogger.class);
        if(myLogger != null){
            System.out.println("-+-+-+: " + myLogger.value());
        } else {
            System.out.println("-+-+-+: null");
        }
    }
}
