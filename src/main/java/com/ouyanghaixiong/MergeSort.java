package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/11
 * @desc
 */
public class MergeSort {
    public static void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int n = arr.length;
        if (n == 0) {
            return;
        }

        helper(arr, 0, n - 1);
    }

    private static void helper(int[] arr, int start, int end) {
        System.out.println("[" + start + ", " + end + "]");
        if (start == end) {
            return;
        }

        int mid = start + (end - start) / 2;
        helper(arr, start, mid);
        helper(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        int[] tmpArr = new int[r - p + 1];
        int cur = 0;
        int p1= p;
        int p2 = q + 1;
        while (p1 <= q && p2 <= r) {
            if (arr[p1] <= arr[p2]) {
                tmpArr[cur++] = arr[p1++];
            } else {
                tmpArr[cur++] = arr[p2++];
            }
        }

        while (p1 <= q) {
                tmpArr[cur++] = arr[p1++];
        }
        while (p2 <= r) {
            tmpArr[cur++] = arr[p2++];
        }

        System.arraycopy(tmpArr, 0, arr, p, tmpArr.length);
    }
}
