package org.kevin.ALGORITHM.offer;

/**
 * @author Kevin.Zng
 * @date 2022/6/9 23:53
 */
public class O46 {

    public static void main(String[] args) {
        int n = 12258;
        System.out.println(translateNum(n));
    }

    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        } else if (num < 26) {
            return 2;
        }

        return recursion(String.valueOf(num));
    }

    private static int recursion(String str) {
        if (str.length() == 0) {
            return 0;
        } else if (str.length() == 1) {
            return 1;
        } else if (str.length() == 2) {
            if (Integer.parseInt(str) < 10) {
                return 1;
            } else {
                return 2;
            }
        }

        String leftOne = str.substring(1);

        String two = str.substring(0, 2);
        String leftTwo = str.substring(2);
        int intTwo = Integer.parseInt(two);
        if (intTwo < 10 || intTwo > 25) {
            return recursion(str);
        }

        return recursion(leftOne) + recursion(leftTwo);
    }
}
