package com.ouyanghaixiong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/4
 * @desc
 */
public class BucketSort {
    public void sort(int[] values) {
        if (values == null) {
            return;
        }
        int n = values.length;
        if (n == 0) {
            return;
        }

        // 确定每个桶的区间长度, interval = (max - min) / (n - 1)
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            if (values[i] > max) {
                max = values[i];
            }
        }
        int d = max - min;
        int interval = d / (n - 1);

        // 创建n个桶, 每个桶都是一个LinkedList
        ArrayList<LinkedList<Integer>> buckets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            buckets.add(new LinkedList<>());
        }

        // 遍历原数组, 将每个元素都放到对应的桶里
        for (int value : values) {
            int index = (value - min) * (n - 1) / d;
            buckets.get(index).add(value);
        }

        // 对每个桶排序
        for (LinkedList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 遍历每个桶, 取出每个元素
        int index = 0;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer value : bucket) {
                values[index] = value;
                index++;
            }
        }
    }
}
