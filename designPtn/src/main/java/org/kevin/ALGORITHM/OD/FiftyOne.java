package org.kevin.ALGORITHM.OD;

import java.util.regex.Pattern;

/**
 * @author Kevin.Zng
 * @date 2022/5/22 00:50
 */
public class FiftyOne {

    public static void main(String[] args) {
        String s = "abc2234019334A334Bc01If56789";
        s = "ab3chd8";
        System.out.println(solution(s));
    }

    private static String solution(String str) {
        String[] ss = str.split("[^\\d]+");

        String result = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            String s = ss[i];
            sb.setLength(0);
            if (s.length() == 0) {
                continue;
            } else if (s.length() == 1) {
                result = result.length() > 0 ? result : s;
            } else {
                char c = s.charAt(0);
                sb.append(c);
                for (int j = 1; j < s.length(); j++) {
                    char tempChar = s.charAt(j);
                    if (tempChar < c) {
                        String tempResult = sb.toString();
                        result = tempResult.length() > result.length() ? tempResult : result;
                        sb.setLength(0);
                    }
                    sb.append(tempChar);
                    c = tempChar;
                }
                result = sb.length() > result.length() ? sb.toString(): result;
            }
        }

        return result;
    }
}
