package org.kevin.ALGORITHM.Monotonous;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Kevin.Zng
 * @date 2022/2/27 12:29
 */
public class MaxSquare {

    @Test
    public void qSquare() {
        int[] n = new int[]{4, 2, 0, 3, 2, 5};
        n = new int[]{2, 1, 5, 6, 2, 3};
        n = new int[]{6,7,5,2,4,5,9,3};
        n = new int[]{5,4,1,2};

//        System.out.println("this.maxSquare(n) = " + this.maxSquare(n));
//        System.out.println("this.paragon(n) = " + this.paragon(n));
//        System.out.println("this.violent(n) = " + this.violent(n));
//        System.out.println("this.otherSolution(n) = " + this.otherSolution(n));
        System.out.println("this.advanceSolution(n) = " + this.advanceSolution(n));
    }

    private int violent(int[] heights) {
        int area = -1;
        for (int i = 0; i < heights.length; i++) {
            // 左边的矩形中，比当前矩形小的下标。
            int j = i;
            for (; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    break;
                }
            }

            // 右边的矩形中，比当前的矩形小的下标
            int k = i;
            for (; k < heights.length; k++) {
                if (heights[k] < heights[i]) {
                    break;
                }
            }

            int width = k - j - 1;
            area = Math.max(area, width * heights[i]);
        }

        return area;
    }

    private int otherSolution(int[] heights) {
        int area = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();

                int width = i - stack.peek() - 1;
                area = Math.max(area, heights[top] * width);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int top = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            area = Math.max(area, heights[top] * width);
        }

        return area;
    }

    private int maxSquare(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxSquare = -1;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                int currentSquare = heights[i] * (i - top + 1);
                int previousSquare = heights[top] * (i - top);
                int currentMaxSquare = Math.max(currentSquare, previousSquare);
                maxSquare = Math.max(currentMaxSquare, maxSquare);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int top = stack.pop();
            int l = heights.length - stack.peek() - 1;
            int currentSquare = heights[top] * l;
            maxSquare = Math.max(currentSquare, maxSquare);
        }

        return maxSquare;
    }

    private int paragon(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        // 矩形的左边比它小的下标, 不存在则填-1：说明左边的矩形都比它大
        int[] left = new int[heights.length];
        Arrays.fill(left, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                left[top] = i;
            }
            stack.push(i);
        }
        stack.clear();

        // 矩形的右边比它小的下标，不存在则为数组的长度：说面右边的所有矩形都比它大
        int[] right = new int[heights.length];
        Arrays.fill(right, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                right[top] = i;
            }
            stack.push(i);
        }

        int maxSquare = -1;
        for (int i = 0; i < heights.length; i++) {
            int length = right[i] - left[i] - 1;
            maxSquare = Math.max(maxSquare, heights[i] * length);
        }

        return maxSquare;
    }

    public int advanceSolution(int[] heights) {
        int area = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        // 局部变量的数组，默认是 0；因为第一个和最后一个也可以不用去管它。
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int top = stack.pop();
                int width = i - stack.peek() - 1;
                area = Math.max(area, newHeights[top] * width);
            }
            stack.push(i);
        }

        return area;
    }
}
