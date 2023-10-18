package org.kevin.ALGORITHM.OD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kevin.Zng
 * @date 2022/5/17 01:40
 */
public class SixtyNine {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println("solution(s) = " + solution(s));
        System.out.println("s2(s) = " + s2(s));
    }

    private static int s2(String s) {
        if (s.length() < 2) {
            return 1;
        }

        int count = s.length();
        int start = 0;
        for (int position = 0, curr = 1; curr < s.length() && position < s.length(); ) {
            if (s.charAt(position) == s.charAt(curr)) {
                count -= 2;
                if (position == start) {
                    position = curr + 1;
                    curr = curr + 2;

                    start = position;
                } else {
                    position -= 1;
                    curr++;
                }
            } else {
                position = curr;
                curr++;
            }
        }

        return count;
    }

    private static int solution(String s) {
        Pattern p = Pattern.compile("[^a-zA-Z]");
        Matcher m = p.matcher(s);
        if (m.find()) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(s);
        boolean flag = true;
        while (flag && sb.length() > 0) {
            flag = false;
            s = sb.toString();
            sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    i++;
                    flag = true;
                    continue;
                }
                sb.append(s.charAt(i));
            }
        }
        return sb.length();
    }
}
