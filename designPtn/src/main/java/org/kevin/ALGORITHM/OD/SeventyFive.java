package org.kevin.ALGORITHM.OD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Kevin.Zng
 * @date 2022/5/14 00:31
 */
public class SeventyFive {

    public static void main(String[] args) {
        String s = "1234567890oiuytrewqahsjdkflgmbnvcxzz";
        s = "112345678991182";

        System.out.println(solution(s));
        System.out.println(solution2(s));
    }

    private static int solution(String s) {
        Map<Character, Integer> times = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer value = times.get(c);
            int v = Objects.isNull(value) ? 1 : value + 1;

            times.put(c, v);
        }

        int max = -1;
        for (Map.Entry<Character, Integer> entry : times.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        return max;
    }

    private static int solution2(String s) {
        int[] result = new int[127];
        Arrays.fill(result, 0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result[c] = result[c] + 1;
        }

        int max = -1;
        for (int i = 0; i < 127; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        return max;
    }
}
