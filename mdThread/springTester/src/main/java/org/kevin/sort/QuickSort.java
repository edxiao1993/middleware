package org.kevin.sort;

/**
 * @author Kevin.Z
 * @version 2021/7/28
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 2, 45, 32, 88, 23, 90, 10, 34, 21, 25, 99};

        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    private void quickSort(int[] arr, int left, int right) {
        int i, j, pivot;
        if (left + 3 <= right) {
            pivot = median3(arr, left, right);
            i = left;
            j = right - 1;
            while (true) {
                while (arr[++i] < pivot) {
                }
                while (arr[--j] > pivot) {
                }
                if(i < j){
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
            swap(arr, i, right - 1);

            quickSort(arr, left, i-1);
            quickSort(arr, i + 1, right);
        }
    }

    private int median3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[left] > arr[center]) {
            swap(arr, left, center);
        }
        if (arr[center] > arr[right]) {
            swap(arr, center, right);
        }
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }

        swap(arr, center, right - 1);
        return arr[right - 1];
    }

    private void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
