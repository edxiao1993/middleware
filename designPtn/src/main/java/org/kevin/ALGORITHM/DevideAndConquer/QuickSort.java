package org.kevin.ALGORITHM.DevideAndConquer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Kevin.Zng
 * @date 2022/2/14 23:47
 */
public class QuickSort {

    @Test
    public void quickSort() {
        int[] arr = {23, 13, 35, 6, 19, 50, 28};
        this.qs(arr, 0, arr.length - 1);
        System.out.println("arr = " + Arrays.toString(arr));
    }

    private int partition(int[] arr, int first, int end) {
        while (first < end) {
            while (first < end && arr[first] <= arr[end]) {
                end--; // scan the right part
            }

            if (first < end) {
                // exchange the position for arr[first] and arr[end]
                int temp = arr[first];
                arr[first] = arr[end];
                arr[end] = temp;
                first++;
            }

            while (first < end && arr[first] <= arr[end]) {
                first++; // scan the left part
            }

            if (first < end) {
                int temp = arr[first];
                arr[first] = arr[end];
                arr[end] = temp;
                end--;
            }
        }

        return first;
    }

    private void qs(int[] arr, int first, int end) {
        int pivot;
        if (first < end) {
            // 为什么要忽略基准？
            // 因为以基准为分界的两边都已经排好序了。
            pivot = partition(arr, first, end);
            this.qs(arr, first, pivot - 1);
            this.qs(arr, pivot + 1, end);
        }
    }
}
