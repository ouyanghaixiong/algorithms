package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/2
 * @desc
 */
public class BubbleSort {
    public int[] sort(int[] values) {
        int n = values.length;
        if (n == 0) {
            return values;
        }

        for (int i = n - 1; i > 0; i--) {
            boolean isSorted = true;
            for (int j = 0; j < i; j++) {
                if (values[j] > values[j + 1]) {
                    int tmp = values[j + 1];
                    values[j + 1] = values[j];
                    values[j] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }

        return values;
    }
}
