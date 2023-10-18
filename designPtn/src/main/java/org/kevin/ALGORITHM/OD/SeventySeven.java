package org.kevin.ALGORITHM.OD;

/**
 * @author Kevin.Zng
 * @date 2022/5/12 01:15
 */
public class SeventySeven {
    public static void main(String[] args) {
        int[] n = new int[]{23, 26, 36, 27}; // 78
        int target = 78;

        n = new int[]{23, 30, 40}; // 26
        target = 26;

        n = new int[]{2, 3, 5, 1, 3, 9, 8, 4, 3, 2}; // 22
        target = 10;

        n = new int[]{33, 33, 33, 35};
        target = 100;

        System.out.println(solution(n, target));
    }

    private static int solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = j - 1; k >= 0; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < target) {
                        System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
                        return sum;
                    }
                }
            }
        }

        return -1;
    }
}
