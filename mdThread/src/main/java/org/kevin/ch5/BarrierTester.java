package org.kevin.ch5;

import java.util.concurrent.*;

/**
 * Note the await().
 * 当所有线程都调用 await 时，Barrier 才会放行。
 * 此时 Barrier 的值会被重制为一开始的值
 *
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class BarrierTester {

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
            System.out.println("doing sth. together~");
            lastSeconds(3L);
        });

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Coder(10L, "BackEnd", cyclicBarrier));
        es.execute(new Coder(3L, "FrontEnd", cyclicBarrier));
    }

    private static void lastSeconds(long second){
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException ignore){}
    }

    static class Coder implements Runnable{
        private long workTime;
        private String name;
        private CyclicBarrier cyclicBarrier;

        public Coder(long workTime, String name, CyclicBarrier cyclicBarrier){
            this.workTime = workTime;
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try{
                System.out.println(this.name + ": are coding...");
                lastSeconds(this.workTime);
                this.cyclicBarrier.await();
                System.out.println("begin debugging");
            } catch (BrokenBarrierException | InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
