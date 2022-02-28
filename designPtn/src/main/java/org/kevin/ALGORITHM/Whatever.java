package org.kevin.ALGORITHM;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 *
 * @author Kevin.Zng
 * @date 2022/2/14 23:43
 */
public class Whatever {

    @Test
    public void t1() {
//        int[] n = new int[]{5, 3, 1, 2, 4};
//        System.out.println("solution(n) = " + Arrays.toString(solution(n)));
        int[] n = new int[]{5, 3, 1, 2, 4};
        System.out.println("solution(n) = " + Arrays.toString(smaller(n)));
    }

    private int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }

        return result;
    }

    private int[] smaller(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        // 单调递增的栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 栈非空。
            // 栈内的第一个
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = nums[top] - nums[i];
            }
            stack.push(i);
        }

        return result;
    }
}
