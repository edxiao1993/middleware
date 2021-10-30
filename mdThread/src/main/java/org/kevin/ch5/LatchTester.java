package org.kevin.ch5;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁的简单例子。在所有的线程都准备好之前，先不要运行。
 * await可以设置最长等待时间
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class LatchTester {

    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException ignore) {
                }
            });
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
