package org.kevin.ALGORITHM;

import java.util.Arrays;

/**
 * @author Kevin.Zng
 * @date 2022/6/8 01:03
 */
public class TwoSix {

    public static void main(String[] args) {
        int[] n = new int[]{0,0,1,1,1,2,2,3,3,4};
        n = new int[]{1,1};
        System.out.println(removeDuplicates(n));
        System.out.println(Arrays.toString(n));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            while (right < nums.length) {
                if (nums[left] != nums[right]) {
                    break;
                }

                right++;
            }
            if (right == nums.length) {
                break;
            }
            nums[++left] = nums[right++];
        }

        return left + 1;
    }
}
