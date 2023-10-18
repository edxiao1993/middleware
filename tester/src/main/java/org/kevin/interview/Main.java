package org.kevin.interview;

import java.util.Scanner;

/**
 * @author Kevin.Zng
 * @date 2022/5/27 19:17
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] lines = in.nextLine().split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            if (a == 0 && b == 0) {
                break;
            }

            System.out.println((a + b));
        }

    }
}
