package org.kevin.threadProblems;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class Foo {
    private volatile int orders = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        orders = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (orders != 2) {
            Thread.onSpinWait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        orders = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (orders != 3) {
            Thread.onSpinWait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
