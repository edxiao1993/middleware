package org.kevin.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Third {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        System.out.println(solution(n, s));
//        System.out.println(another(n, s));
//        System.out.println(third(n, s));
    }

    private static int third(int n, String s) {
        s = s.toLowerCase();
        String transferYY = s.replaceAll("[aeiou]+", "#");
        String transferNN = s.replaceAll("[^aeiou]+", "$");

        return -1;
    }

    private static int another(int n, String s) {
        Set<Character> yySet = new HashSet<>();
        yySet.add('a');
        yySet.add('e');
        yySet.add('i');
        yySet.add('o');
        yySet.add('u');
        s = s.toLowerCase();
        int maxCount = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!flag && yySet.contains(c)) {
                queue.offer(i);
                flag = true;
            }

            if (flag && !yySet.contains(c)) {
                flag = false;
            }
        }

        return -1;
    }

    private static int solution(int n, String s) {
        Set<Character> yySet = new HashSet<>();
        yySet.add('a');
        yySet.add('e');
        yySet.add('i');
        yySet.add('o');
        yySet.add('u');
        s = s.toLowerCase();

        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (yySet.contains(c)) {
                int flaw = n;
                int j = i;
                while (flaw > 0 && j < s.length()) {
                    char tempChar = s.charAt(j++);
                    if (!yySet.contains(tempChar)) {
                        flaw--;
                    }
                }

                if (flaw != 0) {
                    continue;
                }

                while (j < s.length()) {
                    if (!yySet.contains(s.charAt(j))) {
                        break;
                    }
                    j++;
                }

                maxCount = Math.max(maxCount, j - i);

            }
        }

        return maxCount;
    }
}
