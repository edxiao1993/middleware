package org.kevin.ALGORITHM;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Kevin.Zng
 * @date 2022/5/25 00:15
 */
public class SevenThreeEight {

    public static void main(String[] args) {
        int n = 777616726;
//        n = 332;
        System.out.println(anotherSolution(n));
    }

    private static int solution(int n) {
        if (n < 10) {
            return n;
        }

        for (int i = n; i >= 0; i--) {
            if (isSingle(i)) {
                return i;
            }
        }

        return -1;
    }

    private static boolean isSingle(int i) {
        String s = String.valueOf(i);
        for (int j = 0; j < s.length() - 1; j++) {
            if (s.charAt(j) > s.charAt(j + 1)) {
                return false;
            }
        }

        return true;
    }

    private static int anotherSolution(int n) {
        if (n < 10) {
            return n;
        }

        char[] cs = String.valueOf(n).toCharArray();
        int lastCheckPosition = cs.length - 1;
        for (int i = cs.length - 2; i >= 0; i--) {
            if (cs[i] > cs[lastCheckPosition]) {
                for (int j = lastCheckPosition; j < cs.length; j++) {
                    cs[j] = '9';
                }
                lastCheckPosition = i;
                cs[i] = (char) (cs[i] - 1);
            }
        }

        return Integer.parseInt(new String(cs));
    }
}
