package org.kevin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author Kevin.Z
 * @version 2021/6/30
 */
@Aspect
@Component
public class ControllerAOP {
    /**
     * execution(
     *   [public/protect/private]
     *   package.bean.function(parameters)
     *
     * 1. public * *(..) : execution of any public method
     * 2. * set*(..) : execution of any method with a name that begin with set
     * 3. * org.kevin.service.BlogService.*(..) : execution of any method defined by BlogServiceImpl <strong>interface</strong>
     * 4. * org.kevin.service.*.*(..) : execution of any method defined in the service package
     *
     * with(org.kevin.service.*) : Any join point (method execution only in Spring AOP) within the service package:
     * within(com.xyz.service..*) : Any join point (method execution only in Spring AOP) within the service package or one of its <strong>sub-packages</strong>
     * this(com.xyz.service.AccountService) : Any join point (method execution only in Spring AOP) where the proxy implements the AccountService interface:
     */
    @Pointcut("execution(* org.kevin.controller.*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void beforeCut(){
        System.out.println("before controller......");
    }

    @After("pointcut()")
    public void afterCut(){
        System.out.println("after controller......");
    }

    @AfterReturning("pointcut()")
    public void afterReturningCut(){
        System.out.println("after returning,,,,,,");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowingCut(){
        System.out.println("after throwing......");
    }

    @Around("pointcut()")
    public Object aroundCut(ProceedingJoinPoint pjp){
        try {
            System.out.println("in around, before:");

            String className = pjp.getTarget().getClass().getName();

            MethodSignature signature = (MethodSignature) pjp.getSignature();
            Method method = signature.getMethod();

            // get arguments' value
            Object[] args = pjp.getArgs();

            // get arguments' name
            LocalVariableTableParameterNameDiscoverer localVariableTableParameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
            String[] parameterNames = localVariableTableParameterNameDiscoverer.getParameterNames(method);


            Object result = pjp.proceed();
            System.out.println("in around, after~");
            return result;
        } catch (Throwable throwable){
            throwable.printStackTrace();
            return null;
        }
    }
}
