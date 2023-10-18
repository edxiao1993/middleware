package org.kevin.ALGORITHM.OD;

/**
 * @author Kevin.Zng
 * @date 2022/5/20 00:18
 */
public class Four {

    public static void main(String[] args) {
        int n = 3;
        int[] nums = new int[]{1,2,3,4,5};

        n = 4;
        nums = new int[] {5,4,1,1,1};
        System.out.println(solution(n, nums));
    }

    private static int solution(int n, int[] nums) {
        int count = nums.length;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            left = left + nums[i] - n;
            left = Math.max(left, 0);
        }

        int moreTimes = left / n;

        moreTimes += (left % n) > 0 ? 1 : 0;

        return count + moreTimes;
    }
}
