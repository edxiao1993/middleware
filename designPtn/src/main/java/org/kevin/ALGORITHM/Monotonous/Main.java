package org.kevin.ALGORITHM.Monotonous;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Kevin.Zng
 * @date 2022/2/21 00:23
 */
public class Main {

    @Test
    public void testMonotonous() {
        int[] n = new int[]{5, 3, 1, 2, 4};
        System.out.println("monotonous(n) = " + Arrays.toString(monotonous(n)));
    }

    public int[] monotonous(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }

        return result;
    }

    @Test
    public void testMaxSquare() {
        int[] n = new int[]{7,6,5,4,3,2,1};
        System.out.println("maxSquare(n) = " + maxSquare(n));
    }

    public int maxSquare(int[] nums) {
        int maxSquare = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] <= nums[stack.peek()]) {
                int top = stack.pop();
                // 遇到高度下降的矩形，算上该下标，得到的面积
                int currentSquare = (i - top + 1) * nums[i];
                //
                int beforeSquare = (i - top) * nums[top];
                int square = Math.max(currentSquare, beforeSquare);
                maxSquare = Math.max(maxSquare, square);
            }
            stack.push(i);
        }

        return maxSquare;
    }

    @Test
    public void qTemperature() {
        int[] n = new int[]{30, 40, 50, 60};
        System.out.println("this.temperature(n) = " + Arrays.toString(this.temperature(n)));
    }

    private int[] temperature(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int top = stack.pop();
                result[top] = i - top;
            }
            stack.push(i);
        }

        return result;
    }

    @Test
    public void qMaxWidthRamp() {
        int[] n = new int[]{6,0,8,2,1,5};
        System.out.println("this.maxWidthRamp(n) = " + this.maxWidthRamp(n));
    }

    public int maxWidthRamp(int[] nums) {
        int maxWidth = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i ; j--) {
                if(nums[j] >= nums[i]) {
                    maxWidth = Math.max(maxWidth, j - i);
                    break;
                }
            }
        }

        return maxWidth;
    }
}
