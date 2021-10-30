package org.kevin.interview;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class First {
    public static void main(String[] args) {
        t2();
    }

    private static void t1() {
        final Semaphore a = new Semaphore(1);
        final Semaphore b = new Semaphore(0);
        final Semaphore c = new Semaphore(0);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        a.acquire();
                        System.out.println("A");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        b.release();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        b.acquire();
                        System.out.println("B");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        c.release();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        c.acquire();
                        System.out.println("C");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        a.release();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }

    // failed~
    private static void t2() {
        Lock l = new ReentrantLock();
        final Condition a = l.newCondition();
        final Condition b = l.newCondition();
        final Condition c = l.newCondition();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        l.lock();
                        a.await();
                        System.out.println("A");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        b.signal();
                        l.unlock();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        l.lock();
                        b.await();
                        System.out.println("B");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        c.signal();
                        l.unlock();
                    }
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        l.lock();
                        c.await();
                        System.out.println("C");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        a.signal();
                        l.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

    }
}
