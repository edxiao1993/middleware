package org.kevin.ALGORITHM.OD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Kevin.Zng
 * @date 2022/5/24 01:08
 */
public class FiftySeven {

    public static void main(String[] args) {
        String s = "AAACBBAAA";
        s = "AAAAHHHBBCDHHHH";
        System.out.println(solution(s, 3));
    }

    private static int solution(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        char currChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == currChar) {
                count++;
            } else {
                currChar = c;
                count = 1;
            }

            Integer size = map.get(currChar);
            if (Objects.isNull(size)) {
                map.put(currChar, count);
            } else {
                map.put(currChar, Math.max(size, count));
            }
        }

        if (map.size() < k) {
            return -1;
        }

        List<Map.Entry<Character, Integer>> helper = new ArrayList<>(map.entrySet());
        helper.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));


        return helper.get(k - 1).getValue();
    }
}
