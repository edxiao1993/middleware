package org.kevin.interview;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Kevin.Zng
 * @date 2022/6/7 00:02
 */
public class ThreadTest implements Runnable {

    static int b = 10;

    public synchronized void m1() throws Exception {
        b = 100;
        System.out.println("m1");
        this.wait(10);
//        Thread.sleep(10);
        System.out.println("m1, b = " + b);
    }

    public synchronized void m2() throws Exception {
        b = 200;
        System.out.println("m2");
        this.wait(1000);
//        Thread.sleep(1000L);
        System.out.println("m2, b = " + b);
    }

    public static void main(String[] args) throws Exception {
        ThreadTest tt = new ThreadTest();
        Thread t = new Thread(tt);
        t.start();
        tt.m2();
        System.out.println("m, b = " + b);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
