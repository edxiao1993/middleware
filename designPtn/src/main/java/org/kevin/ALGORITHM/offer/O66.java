package org.kevin.ALGORITHM.offer;

import java.util.Arrays;

/**
 * @author Kevin.Zng
 * @date 2022/6/10 00:23
 */
public class O66 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        nums = new int[]{};
        System.out.println(Arrays.toString(solution(nums)));
    }

    private static int[] solution(int[] a) {
        if (a.length < 1) {
            return new int[0];
        }

        // prefix sum
        int[] leftSum = new int[a.length];
        int[] rightSum = new int[a.length];

        leftSum[0] = 1;
        for (int i = 1; i < a.length; i++) {
            leftSum[i] = leftSum[i - 1] * a [i - 1];
        }

        rightSum[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] * a[i + 1];
        }

        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = leftSum[i] * rightSum[i];
        }

        return ans;
    }
}
