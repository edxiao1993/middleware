package org.kevin.ALGORITHM.DevideAndConquer;

/**
 * @author Kevin.Zng
 * @date 2022/2/21 22:36
 */
public class Paint {

    public static void main(String[] args) {
        int[] n = new int[]{1, 2, 3, 4, 5, 6, 6, 6};
        System.out.println("solve(0, n.length, 0, n) = " + solve(0, n.length, 0, n));
    }

    private static int solve(int left, int right, int height, int[] nums) {
        if (left >= right) {
            return 1;
        }

        int minHeight = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            if (minHeight > nums[i]) {
                minHeight = nums[i];
            }
        }

        int sum = minHeight - height;
        if (sum > (right - left + 1)) {
            return right - left + 1;
        }

        int r = right;
        int l = left;
        while (left < right) {
            if (nums[left] == minHeight) {
                left++;
                continue;
            }

            int start = left;
            while (left < right && nums[left] > minHeight) {
                left++;
            }

            sum += solve(start, left, minHeight, nums);
        }

        return Math.min(r - l, sum);
    }
}
