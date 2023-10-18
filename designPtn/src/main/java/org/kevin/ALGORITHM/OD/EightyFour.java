package org.kevin.ALGORITHM.OD;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin.Zng
 * @date 2022/5/8 17:54
 */
public class EightyFour {

    public static void main(String[] args) {
        String s = "22,221";

        s = "3,22";
        s = "4589,101,41425,9999";
        solution(s);
    }

    private static String solution(String s) {
        String[] ss = s.split(",");

        List<String> result =  Arrays.stream(ss).sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.equals(s2)) {
                    return 0;
                }

                int i = 0;
                for (i = 0; i < s1.length() && i < s2.length(); i++) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return s2.charAt(i) - s1.charAt(i);
                    }
                }

                if (s1.length() > s2.length()) {
                    return s1.charAt(i - 1) > s1.charAt(i) ? 1 : -1;
                } else {
                    return s2.charAt(i - 1) > s2.charAt(i) ? 1 : -1;
                }
            }
        }).collect(Collectors.toList());

        for (String s1 : result) {
            System.out.println(s1);
        }
        return "";
    }
}
