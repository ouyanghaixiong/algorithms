package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/6
 * @desc 删去k个数字后的最小值
 */
public class DeleteNumberRemainMinimum {
    public static Integer[] get(Integer[] values, int k) {
        if (values == null) {
            return null;
        }
        int n = values.length;
        if (n == 0) {
            return values;
        }
        if (n == k) {
            return new Integer[]{0};
        }

        // 一共k轮, 每一轮删除一个数字, 把删除的未知置为null
        int numDeleted = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (values[j] == null) {
                    continue;
                }
                int nextIndex = j + 1;
                while (nextIndex < n && values[nextIndex] == null) {
                    nextIndex++;
                }
                if (values[j] >= values[nextIndex]) {
                    values[j] = null;
                    numDeleted++;
                    break;
                }
            }
        }
        if (numDeleted < k) {
            for (int i = n - 1; i >= n - k + numDeleted; i--) {
                values[i] = null;
            }
        }

        // 复制结果
        int index = 0;
        Integer[] newValues = new Integer[n - k];
        for (Integer value : values) {
            if (value == null) {
                continue;
            }
            newValues[index++] = value;
        }

        return newValues;
    }
}
