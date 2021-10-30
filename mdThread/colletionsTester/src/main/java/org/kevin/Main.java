package org.kevin;

/**
 * @author Kevin.Z
 * @version 2021/7/27
 */
public class Main {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println("hello world~");
        int x = 10;
        int y = x >> 1;
        System.out.println(y);

        int n = -1 >>> Integer.numberOfLeadingZeros(x - 1);
        int s = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(s);
    }
}
