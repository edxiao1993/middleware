package org.kevin.sort;

/**
 * @author Kevin.Z
 * @version 2021/7/28
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 2, 45, 32, 88, 23, 90, 10, 34, 21, 25, 99};
//        insertSort(arr);
        new InsertSort().sortSecond(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    private static void insertSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int i, j, x;
        for (i = 1; i < arr.length - 1; i++) {
            x = arr[i];
            for (j = i; j > 0 && arr[j - 1] > x; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = x;
        }
    }




















    private void sortSecond(int[] arr){
        int i, j, x;
        for (i = 1; i < arr.length - 1; i++) {
            x = arr[i];
            for (j = i; j > 0 && arr[j - 1] > x; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = x;
        }
    }
}
