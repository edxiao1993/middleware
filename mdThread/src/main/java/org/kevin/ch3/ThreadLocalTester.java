package org.kevin.ch3;

/**
 * ThreadLocal
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class ThreadLocalTester {
    private static ThreadLocal<String> threadVal = new ThreadLocal<>();

    private static void print(String str){
        System.out.println("print: " + str);
        threadVal.remove();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            threadVal.set("thread first");
            print("first");
            System.out.println("after remove:" + threadVal.get());
        });

        Thread t2 = new Thread(() -> {
            threadVal.set("thread second");
            print("second");
            System.out.println("after remove:" + threadVal.get());
        });

        t1.start();
        t2.start();
    }
}
