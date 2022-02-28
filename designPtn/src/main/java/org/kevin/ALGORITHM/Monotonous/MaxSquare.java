package org.kevin.ALGORITHM.Monotonous;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Kevin.Zng
 * @date 2022/2/27 12:29
 */
public class MaxSquare {

    @Test
    public void qSquare() {
        int[] n = new int[]{2,1,2};
        System.out.println("this.maxSquare(n) = " + this.maxSquare(n));
    }

    private int maxSquare(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxSquare = -1;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                int currentSquare = heights[i] * (i - top + 1);
                int previousSquare = heights[top] * (i- top);
                int currentMaxSquare = Math.max(currentSquare, previousSquare);
                maxSquare = Math.max(currentMaxSquare, maxSquare);
            }
            stack.push(i);
        }

        maxSquare = Math.max(maxSquare, heights[stack.pop()]);
        if(stack.isEmpty()){
            return maxSquare;
        }
        while (!stack.isEmpty() && stack.size()> 1) {
            int top = stack.pop();
            int length = top - stack.peek();
            int currentSquare = heights[top] * length;
            maxSquare = Math.max(currentSquare, maxSquare);
        }
        maxSquare = Math.max(maxSquare, heights[stack.pop()] * heights.length);

        return maxSquare;
    }
}
