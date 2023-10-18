package org.kevin.ALGORITHM.OD;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Kevin.Zng
 * @date 2022/5/18 00:20
 */
public class SixthFive {
    public static void main(String[] args) {
        String s = "AbCdeFG";
//        s = "fAdDAkBbBq";

        int k = 3; // 5
//        k = 4; // 6
        System.out.println(solution(s, k));
    }

    private static int solution(String s, int k) {
        Map<Character, Integer> position = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (Objects.isNull(position.get(s.charAt(i)))) {
                position.put(s.charAt(i), i);
            }
        }

        char[] cs = s.toCharArray();
        Arrays.sort(cs);

        char t = k > cs.length ? cs[cs.length - 1] : cs[k - 1];
        return position.get(t);
    }
}
