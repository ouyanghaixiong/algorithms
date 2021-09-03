package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/2
 * @desc
 */
public class CockTailSort {
    public int[] sort(int[] values) {
        int n = values.length;
        if (n == 0) {
            return values;
        }

        for (int i = 0; i < n / 2; i++) {

            boolean isSorted = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    swap(values, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            isSorted = true;
            for (int j = n - 1 - i; j > 0; j--) {
                if (values[j] < values[j - 1]) {
                    swap(values, j - 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }

        return values;
    }

    private void swap(int[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
