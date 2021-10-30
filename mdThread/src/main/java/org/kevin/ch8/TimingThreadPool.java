package org.kevin.ch8;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * @author Kevin.Z
 * @version 2021/7/25
 */
public class TimingThreadPool extends ThreadPoolExecutor {
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    private final Logger log = Logger.getLogger("TimingThreadPool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();

    public TimingThreadPool(int corePoolSize){
        super(corePoolSize, corePoolSize, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r){
        super.beforeExecute(t, r);
        log.fine("whatever");
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t){
        try{
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            totalTime.addAndGet(taskTime);
            log.fine("whatever");
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated(){
        try {
            log.info("whatever");
        } finally {
            super.terminated();
        }
    }
}
