package org.kevin.interview;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class First {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        String[] ss = s.split("[^\\d]+");

        int maxLength = 0;
        for (String str : ss) {
            if (str.length() == 0) {
                continue;
            }

            int count = 1;
            char lastChar = str.charAt(0);
            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (lastChar <= c) {
                    count++;
                } else {
                    maxLength = Math.max(count, maxLength);
                    count = 1;
                }

                lastChar = c;
            }

            maxLength = Math.max(count, maxLength);
        }

        return maxLength;
    }
}
