package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/11
 * @desc
 */
public class ShellSort {
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        if (n == 0) {
            return;
        }

        int d = n / 2;
        while (d >= 1) {
            for (int start = 0; start < d; start++) {
                for (int i = start; i + d < n; i += d) {
                    int tmp = arr[i + d];
                    int j;
                    for (j = i; j >= start; j -= d) {
                        if (tmp >= arr[j]) {
                            break;
                        }
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = tmp;
                }
            }
            d = d / 2;
        }
    }
}
