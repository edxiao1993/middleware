package org.kevin.proxyPtn.mytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Kevin.Zng
 * @date 2022/2/25 00:20
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private final Object target;

    public InvocationHandlerImpl (Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invocation handler implementation start!");
        method.invoke(target, args);
        System.out.println("invocation handler implementation ends!");
        return null;
    }
}
