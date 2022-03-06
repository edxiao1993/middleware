package org.kevin.ALGORITHM.Monotonous;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Kevin.Zng
 * @date 2022/3/7 00:48
 */
public class Trap {

    @Test
    public void t() {
        int[] n = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        n = new int[] {4,2,0,3,2,5};
        n = new int[] {4,0,0,0,8};
        System.out.println(this.trap(n));
    }

    private int trap(int[] height) {
        int capacity = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < height.length; i++) {
            while (stack.peek() != -1 && height[i] >= height[stack.peek()]) {
                int top = stack.pop();
                int secondTop = stack.peek();
                if (secondTop == -1) {
                    break;
                }
                int minHeight = Math.min(height[secondTop], height[i]);
                int targetHeight = minHeight - height[top];
                capacity += (i - secondTop - 1) * targetHeight;
            }
            stack.push(i);
        }

        return capacity;
    }
}
