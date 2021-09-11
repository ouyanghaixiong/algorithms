package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/11
 * @desc
 */
public class SelectionSort {
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        if (n == 0) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            // 找最小值
            int minIndex = i;
            int j;
            for (j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换min和arr[i]
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }
}
