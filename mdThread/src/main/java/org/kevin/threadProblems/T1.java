package org.kevin.threadProblems;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class T1 {

    public static void main(String[] args) {
        Runnable first = () -> {
            System.out.println("first");
        };
        Runnable second = () -> {
            System.out.println("second");
        };
        Runnable third = () -> {
            System.out.println("third");
        };
    }
}
