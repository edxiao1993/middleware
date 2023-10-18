package org.kevin.ALGORITHM;

/**
 * @author Kevin.Zng
 * @date 2022/5/8 00:33
 */
public class PreSum {

    public static void main(String[] args) {
        int[] n = new int[] {1, 2, 3, 2, 1, 0, 5};
        n = new int[] {0, 0, 0};
        n = new int[] {1, 2, 3, 4, 1, 3, 0, 2, 3};
//        System.out.println("solution(n) = " + solution(n));
        System.out.println("s2(n) = " + s2(n));
    }

    private static int solution(int[] nums) {
        int count = 0;

        while (true) {
            boolean hasTab = false;
            boolean breakPoint = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= 1;
                    hasTab = true;

                    if (breakPoint) {
                        count++;
                        breakPoint = false;
                    }
                } else if (nums[i] == 0 && hasTab) {
                    breakPoint = true;
                }
            }

            if (hasTab) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    private static int s2(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int sum = 0;
        int tabs = 0;
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i] > preSum[i - 1]) {
                tabs = Math.max(tabs, preSum[i] - preSum[i - 1]);
            } else if (preSum[i] == preSum[i - 1]) {
                sum += tabs;
                tabs = 0;
            }
        }

        return sum + tabs;
    }
}
