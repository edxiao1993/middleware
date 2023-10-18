package org.kevin.ALGORITHM.OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/5/15 01:46
 */
public class SeventyThree {
    public static void main(String[] args) {
        String s = "BBBBabababbCCCCCCCAAA";
//        s = "xyxyXX";
        System.out.println(solution(s));
    }

    private static String solution(String s) {
        int[] arr = new int[127];
        Arrays.fill(arr, 0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c] = arr[c] + 1;
        }

        Map<Character, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                char c = (char) i;
                tempMap.put(c, arr[i]);
            }
        }

        List<Character> keyList = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
            keyList.add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();
        List<Character> lowSorted = keyList.stream().sorted(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (!tempMap.get(o1).equals(tempMap.get(o2))) {
                    return tempMap.get(o2).compareTo(tempMap.get(o1));
                }

                if (o1 >= 'a' && o2 <= 'Z') {
                    return -1;
                } else if (o2 >= 'a' && o1 <= 'Z') {
                    return 1;
                }

                return o1.compareTo(o2);
            }
        }).collect(Collectors.toList());

        lowSorted.forEach(v -> sb.append(v).append(":").append(tempMap.get(v)).append(";"));

        return sb.substring(0, sb.length() - 1);
    }
}
