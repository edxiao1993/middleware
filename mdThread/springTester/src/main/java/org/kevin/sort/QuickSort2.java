package org.kevin.sort;

/**
 * @author Kevin.Z
 * @version 2021/7/28
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 2, 45, 32, 88, 23, 90, 10, 34, 21, 25, 99};
        quicksort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    static void quicksort(int n[],int left,int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp -1);
            quicksort(n, dp +1, right);
        }
    }

    static int partition(int n[],int left,int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }
}
