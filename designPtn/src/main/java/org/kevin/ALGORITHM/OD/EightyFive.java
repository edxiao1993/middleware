package org.kevin.ALGORITHM.OD;

import java.util.Objects;

/**
 * @author Kevin.Zng
 * @date 2022/5/7 00:01
 */
public class EightyFive {

    public static void main(String[] args) {
        String s = "1 1 5 1 5 2 4 4";
        s = "2 2 3 4 4 5 1 2 2 3 4 5 2 4 4 5 3 4";
        System.out.println("solution(s) = " + solution(s));
    }

    /**
     * 1:A, 2:copy, 3:cut, 4:print, 5:all
     *
     * @param s
     * @return
     */
    private static long solution(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return 0;
        }
        String[] ss = s.split(" ");
        long count = 0L;

        String clickBoard = "";
        String selected = "";
        for (String s1 : ss) {
            switch (s1) {
                case "1":
                    if (selected.length() > 0) {
                        count = 1;
                        selected = "";
                    } else {
                        count++;
                    }
                    break;
                case "2":
                    if (selected.length() > 0) {
                        clickBoard = selected;
                    }
                    break;
                case "3":
                    if (selected.length() > 0) {
                        count = 0;
                        clickBoard = selected;
                        selected = "";
                    }
                    break;
                case "4":
                    if (clickBoard.length() > 0) {
                        if (selected.length() > 0) {
                            count = Long.parseLong(clickBoard);
                            selected = "";
                        } else {
                            count += Long.parseLong(clickBoard);
                        }
                    }
                    break;
                case "5":
                    if (count > 0) {
                        selected = String.valueOf(count);
                    }
                    break;
            }
        }

        return count;
    }
}
