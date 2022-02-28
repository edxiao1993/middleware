package org.kevin.proxyPtn.mytest;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Kevin.Zng
 * @date 2022/2/23 23:46
 */
public class MyTest {
    @Test
    public void testProxy() {
        UserDao userDao = new UserDaoImpl();
        // 直接调用 getProxyInstance() 的方法
        UserDao proxy = (UserDao) new MyProxy(userDao).getProxyInstance();
        proxy.save();
        System.out.println("---------");

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("other transaction start!");
                method.invoke(userDao, args);
                System.out.println("other transaction ends!");
                return null;
            }
        };
        UserDao otherProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),
                handler);
        otherProxy.save();
        System.out.println("---------");

        // 也可以像下面这样子，直接处理。尽管会直观一些，但尽量还是封装下……
        UserDao anotherProxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),
                (proxy1, method, args) -> {
                    System.out.println("another transaction start!");
                    method.invoke(userDao, args);
                    System.out.println("another transaction ends!");
                    return null;
                });
        anotherProxy.save();
        System.out.println("---------");

        InvocationHandler invocationHandler = new InvocationHandlerImpl(userDao);
        UserDao invocationHandlerImpl = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(),
                invocationHandler);
        invocationHandlerImpl.save();
    }

}
