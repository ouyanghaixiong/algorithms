package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/3
 * @desc 升序排列数组, 所以需要用到大顶堆
 */
public class HeapSort {
    public void adjust(int[] arr, int cur, int len) {
        int tmp = arr[cur];

        while (cur * 2 + 1 < len) {
            int child = cur * 2 + 1;
            if (child + 1 < len && arr[child] < arr[child + 1]) {
                child++;
            }
            // 注意这里要用tmp跟子节点值比较, 而不是arr[cur], 因为arr[cur] 有可能已经被arr[child]覆盖
            if (tmp >= arr[child]) {
                break;
            }
            arr[cur] = arr[child];
            cur = child;
        }
        arr[cur] = tmp;
    }

    public void sort(int[] arr) {
        // 最后一个非叶子节点的下标最多为n/2 -1, 我们只要从非叶子节点调整就可以了
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int p = arr[i];
            arr[i] = arr[0];
            arr[0] = p;
            // 注意不要调整已经就位的arr[i]
            adjust(arr, 0, i);
        }
    }
}
