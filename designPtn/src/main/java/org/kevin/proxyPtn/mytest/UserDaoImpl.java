package org.kevin.proxyPtn.mytest;

/**
 * @author Kevin.Zng
 * @date 2022/2/23 23:43
 */
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
        System.out.println("I am going to save an Object");
    }
}
