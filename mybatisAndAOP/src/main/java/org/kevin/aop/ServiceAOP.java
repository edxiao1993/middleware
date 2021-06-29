package org.kevin.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Aspect
@Component
public class ServiceAOP {
    @Pointcut("execution(* org.kevin.service.*.insert(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforeCut(){
        System.out.println("here is Service AOP:::before");
    }

    @After("pointcut()")
    public void afterCut(){
        System.out.println("here is Service AOP:::after");
    }
}
