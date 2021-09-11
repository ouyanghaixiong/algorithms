package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/11
 * @desc
 */
public class InsertionSort {
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        if (n == 0) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int tmp = arr[i];
            int j = i;
            while (j >= 1) {
                if (tmp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
                j--;
            }
            arr[j] = tmp;
        }
    }
}
