package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/3
 * @desc
 */
public class ValueCountSort {
    public void sort(int[] values) {
        if (values == null) {
            return;
        }
        int n = values.length;
        if (n == 0) {
            return;
        }

        // 创建计数数组
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        int[] valueCounts = new int[max - min + 1];

        // 计数
        for (int value : values) {
            valueCounts[value-min]++;
        }
        // 累加
        for (int i = 1; i < valueCounts.length; i++) {
            valueCounts[i] = valueCounts[i] + valueCounts[i-1];
        }

        // 反向遍历原数组
        int[] sortedValues = new int[values.length];
        for (int i = values.length - 1; i >=0; i--) {
            int index = values[i] - min;
            int count = valueCounts[index];
            sortedValues[count-1] = values[i];
            valueCounts[index]--;
        }

        System.arraycopy(sortedValues, 0, values, 0, sortedValues.length);
    }
}
