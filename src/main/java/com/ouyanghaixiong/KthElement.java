package com.ouyanghaixiong;

import java.util.Arrays;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class KthElement {
    public static int getByHeap(int[] arr, int k) {
        if (arr == null) {
            throw new NullPointerException("arr can not be null");
        }
        int n = arr.length;
        if (n == 0) {
            throw new NullPointerException("arr can not be empty");
        }
        buildHeap(arr, 0, k);
        for (int i = k; i < n; i++) {
            if (arr[i] < arr[0]) {
                continue;
            }
            arr[0] = arr[i];
            adjust(arr, 0, k);
        }

        return arr[0];
    }

    /**
     * @param arr
     * @param start 左闭
     * @param end   右开
     */
    protected static void adjust(int[] arr, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int tmp = arr[start];
        int cur = start;
        while (cur * 2 < end || cur * 2 + 1 < end) {
            int min = tmp;
            int minIndex = cur;
            if (cur * 2 < end && arr[2 * cur] < min) {
                min = arr[2 * cur];
                minIndex = 2 * cur;
            }
            if (cur * 2 + 1 < end && arr[2 * cur + 1] < min) {
                min = arr[2 * cur + 1];
                minIndex = 2 * cur + 1;
            }
            if (minIndex == start) {
                break;
            }
            arr[cur] = arr[minIndex];
            cur = minIndex;
        }
        arr[cur] = tmp;
    }

    protected static void buildHeap(int[] arr, int start, int end) {
        for (int i = end / 2 - 1; i >= start; i--) {
            adjust(arr, i, end);
        }
    }

    public static int getByPartition(int[] arr, int k) {
        return partitionHelper(arr, 0, arr.length, k);
    }

    /**
     * @param arr
     * @param start 左闭
     * @param end   右开
     * @param k
     * @return
     */
    protected static int partitionHelper(int[] arr, int start, int end, int k) {
        int mid = partition(arr, start, end);
        if (mid + 1 == k) {
            return arr[k];
        } else if (mid < k) {
            return partitionHelper(arr, mid + 1, end, k - mid - 1);
        } else {
            return partitionHelper(arr, 0, mid, k);
        }
    }

    protected static int partition(int[] arr, int start, int end) {
        int pivot = arr[end - 1];
        int left = 0;
        int right = end - 1;
        while (left < right) {
            // left指向小于pivot的元素
            while (left < end - 1 && arr[left] >= pivot) {
                left++;
            }
            // right指向大于pivot的元素
            while (right > 0 && arr[right] <= pivot) {
                right--;
            }
            // 交换arr[left] arr[right]
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        // 此时left==right
        // 交换arr[left] pivot
        arr[end - 1] = arr[left];
        arr[left] = pivot;

        // 此时arr[left]一定指向pivot
        return left;
    }
}
