package org.kevin.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/6/1 01:14
 */
public class FiveOne {

    public static void main(String[] args) {
        int[] n = new int[]{-1, 0, 1, 2, -1, -4};
        n = new int[]{0, 0, 0, 0};
        n = new int[]{0};

        FiveOne fo = new FiveOne();
        System.out.println(fo.threeSum(n));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int curr = 0;
        while (curr < numList.size()) {
            int left = curr + 1;
            int right = numList.size() - 1;
            while (left < right) {
                int sum = numList.get(curr) + numList.get(left) + numList.get(right);
                if (sum == 0) {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(numList.get(curr));
                    tempList.add(numList.get(left));
                    tempList.add(numList.get(right));
                    if (!result.contains(tempList)) {
                        result.add(tempList);
                    }
                    left++;
                    right--;
                    continue;
                }

                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

            curr++;
        }

        return result;
    }
}
