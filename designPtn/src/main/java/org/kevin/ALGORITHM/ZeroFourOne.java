package org.kevin.ALGORITHM;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Kevin.Zng
 * @date 2022/5/26 23:44
 */
public class ZeroFourOne {

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(ma.next(3));
        System.out.println(ma.next(5));
    }

    private static class MovingAverage {
        private final Queue<Integer> queue;
        private int size;

        public MovingAverage(int size) {
            this.size = size;
            queue = new ArrayDeque<>(size);
        }

        public double next(int val) {
            if (queue.size() == size) {
                queue.poll();
            }

            queue.offer(val);
            long sum = queue.stream().mapToInt(o -> o).sum();

            return sum / (queue.size() * 1.0);
        }
    }
}
