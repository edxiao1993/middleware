package org.kevin.singletonPtn.singletonEmp;

import org.junit.Test;

/**
 * 实际操作一遍的话，效果应该会好很多很多
 * 试着把 Web 项目的某个 service 改成用 枚举 实现的 单例。
 * 一定会很有趣。
 *
 * @author Kevin.Z
 * @version 2021/11/24
 */
public class SingletonTest {

    @Test
    public void testSingleton() {
        ChocolateEnum ce = ChocolateEnum.UNIQUE_INSTANCE;
        ce.fill();
        ce.drain();

        ChocolateBoiler cb = ChocolateBoiler.getInstance();
        cb.fill();
        cb.drain();
    }
}
