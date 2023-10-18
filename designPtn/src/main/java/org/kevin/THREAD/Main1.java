package org.kevin.THREAD;

/**
 * @author Kevin.Zng
 * @date 2022/6/8 00:15
 */
public class Main1 implements Runnable {
    
    int b = 10;

    synchronized void m1() throws InterruptedException {
        b = 1;
        System.out.println("m1");
        Thread.sleep(10L);
        System.out.println("end m1:::" + b);
    }

    synchronized void m2() throws InterruptedException {
        b = 2;
        System.out.println("m2");
        Thread.sleep(1000L);
        System.out.println("end m2:::" + b);
    }

    public static void main(String[] args) throws Exception {
        Main1 main1 = new Main1();
        Thread thread = new Thread(main1);
        thread.start();

        while (thread.isAlive()){}
        main1.m2();
        System.out.println("end main");
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
