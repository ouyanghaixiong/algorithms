package com.ouyanghaixiong;

import java.util.Arrays;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/3
 * @desc
 */
public class HeapSort {
    public void adjust(int[] arr, int cur, int len) {
        int tmp = arr[cur];

        while (cur * 2 + 1 < len) {
            int child = cur * 2 + 1;
            if (child + 1 < len && arr[child] < arr[child + 1]) {
                child++;
            }
            if (tmp >= arr[child]) {
                break;
            }
            arr[cur] = arr[child];
            cur = child;
        }
        arr[cur] = tmp;
    }

    public void sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = arr.length - 1; i > 0; i--) {
            int p = arr[i];
            arr[i] = arr[0];
            arr[0] = p;
            adjust(arr, 0, i);
        }
    }
}
