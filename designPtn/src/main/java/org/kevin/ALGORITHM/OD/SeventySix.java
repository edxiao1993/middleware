package org.kevin.ALGORITHM.OD;

import java.util.Arrays;

/**
 * @author Kevin.Zng
 * @date 2022/5/13 00:37
 */
public class SeventySix {
    public static void main(String[] args) {
        int[] n = new int[]{123, 124, 125, 121, 119, 122, 126, 123};
        n = new int[]{120, 110, 100, 90, 80, 70};
        System.out.println(Arrays.toString(solution(n)));
    }

    private static int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    result[i] = j;
                    break;
                }
            }
        }

        return result;
    }
}
