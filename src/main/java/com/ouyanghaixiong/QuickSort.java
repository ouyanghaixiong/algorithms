package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/2
 * @desc
 */
public class QuickSort {
    /**
     * 快速分区
     *
     * @param values 数组
     * @return 分区点
     */
    public Integer partition(int[] values, int start, int end) {
        if (values == null) {
            return null;
        }
        if (start == end) {
            return start;
        }
        if (start > end) {
            throw new IllegalArgumentException("start can not greater than end.");
        }

        int pivot = values[start];
        int left = start;
        int right = end - 1;

        while (true) {
            while (values[left] <= pivot && left + 1 <= end - 1) {
                left++;
            }
            while (values[right] >= pivot && right - 1 >= start) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(values, left, right);
            if (left + 1 <= end - 1) {
                left++;
            }
            if (right - 1 >= start) {
                right--;
            }
        }

        swap(values, start, right);

        return right;
    }

    public void sort(int[] values) {
        recursiveSort(values, 0, values.length);
    }

    private void recursiveSort(int[] values, int start, int end) {
        if (end == start) {
            return;
        }

        if (end - start == 1) {
            return;
        }

        Integer p = partition(values, start, end);
        System.out.println(p);
        recursiveSort(values, start, p);
        recursiveSort(values, p + 1, end);
    }

    private void swap(int[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
