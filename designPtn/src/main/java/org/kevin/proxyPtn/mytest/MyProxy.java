package org.kevin.proxyPtn.mytest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Kevin.Zng
 * @date 2022/2/23 23:43
 */
public class MyProxy {
    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 有三个参数，后面两个 method 和 args 没什么好说的。
                    // 第一个参数实际上是指向自身，method.invoke(proxy, args) 的话，就是调用自己了，无限递归……
                    // 因此，应该用上面定义的 target
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("transaction starts!");
                        method.invoke(target, args);
                        System.out.println("transaction ends!");

                        return null;
                    }
                });
    }
}
