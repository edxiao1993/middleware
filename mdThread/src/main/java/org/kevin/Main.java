package org.kevin;


/**
 * @author Kevin.Z
 * @version 2021/7/24
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {22, 33, 44, 55}, {66, 77, 88, 99}, {111,222,333,444}};

        int[][] t1 = { {1, 2, 3, 4, 5},
                {11,22,33,44,55}
        };
        fn(arr, 6, 4, 0);
//        fn2(arr, 5, 4, 0);
    }

    private static void fn2(int[][] arr, int row, int column, int times) {

        int r = times;
        int c = 0;
        //first row:
        for (c = times; c <= column - 1; c++) {
            System.out.print(arr[r][c] + ",");
        }
        c--;

        for (r = 1; r <= row - 1; r++) {
            System.out.print(arr[r][c] + ",");
        }
        r--;

        for (c = column - 2; c >= 0; c--) {
            System.out.print(arr[r][c] + ",");
        }
        c++;

        for (r = row - 2; r > 0; r--) {
            System.out.print(arr[r][c] + ",");
        }
    }

    private static void fn(int[][] arr, int row, int column, int times) {
        if ((row - (times + 1) * 2) < 0) {
            return;
        }
        if ((column - (times + 1) * 2) < 0) {
            return;
        }

        // row = first row
        for (int i = times; i < column - 2 * times; i++) {
            System.out.print(arr[times][i] + ",");
        }

        // column = last column
        for (int i = 1; i < row - times; i++) {
            System.out.print(arr[i][column - 1 - times] + ",");
        }

        // row = last row
        for (int i = column - 2 - times; i >= times; i--) {
            System.out.print(arr[row - 1 - times][i] + ",");
        }

        // column = first column
        for (int i = row - 2 - times; i > times; i--) {
            System.out.print(arr[i][times] + ",");
        }
        System.out.println();

        times++;
        fn(arr, row, column, times);
    }
}
