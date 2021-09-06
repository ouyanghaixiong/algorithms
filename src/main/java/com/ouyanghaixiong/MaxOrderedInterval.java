package com.ouyanghaixiong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc 将数组排序, 找两两相邻的最大间隔
 */
public class MaxOrderedInterval {
    public static int get(int[] values) {
        // 将数组的元素分桶, 只记录每个桶的最大值和最小值
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
        }
        int numBucket = 10;

        ArrayList<Map<String, Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numBucket; i++) {
            Map<String, Integer> bucket = new HashMap<>();
            bucket.put("max", Integer.MIN_VALUE);
            bucket.put("min", Integer.MAX_VALUE);
            buckets.add(bucket);
        }

        for (int value : values) {
            int index = (value - min) * (numBucket - 1) / (max - min);
            Map<String, Integer> bucket = buckets.get(index);
            if (value < bucket.get("min")) {
                bucket.put("min", value);
            }
            if (value > bucket.get("max")) {
                bucket.put("max", value);
            }
        }

        // 遍历每个桶, 取当前桶的最大值与下一个非空桶的最小值, 求差值, 记录最大差值就是所求
        int maxInterval = Integer.MIN_VALUE;
        for (int i = 0; i < buckets.size() - 1; i++) {
            Map<String, Integer> curBucket = buckets.get(i);
            // 寻找下一个非空桶
            int j = 1;
            while (buckets.get(i + j).get("min").equals(Integer.MAX_VALUE)) {
                j++;
            }
            Map<String, Integer> nextBucket = buckets.get(i + j);
            if (curBucket == null) {
                continue;
            }
            int maxOfCurBucket = curBucket.get("max");
            int minOfNextBucket = nextBucket.get("min");
            int curInterval = minOfNextBucket - maxOfCurBucket;
            if (curInterval > maxInterval) {
                maxInterval = curInterval;
            }
        }

        return maxInterval;
    }
}
