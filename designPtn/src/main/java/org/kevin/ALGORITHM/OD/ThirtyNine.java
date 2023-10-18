package org.kevin.ALGORITHM.OD;

/**
 * @author Kevin.Zng
 * @date 2022/5/21 00:58
 */
public class ThirtyNine {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }

    private static String solution(int n) {
        String[] ss = new String[n + 1];
        ss[0] = "1";

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.setLength(0);
            String temp = ss[i - 1];
            char lastChar = temp.charAt(0);
            int count = 1;
            for (int j = 1; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (lastChar == c) {
                    count++;
                } else {
                    sb.append(count).append((lastChar - 48));
                    count = 1;
                    lastChar = c;
                }
            }
            sb.append(count).append(lastChar - 48);
            ss[i] = sb.toString();
        }

        return ss[n];
    }
}
