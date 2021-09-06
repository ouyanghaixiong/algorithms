package com.ouyanghaixiong;

import java.util.Arrays;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc 寻找数字全排列的下一个数
 */
public class NextGreaterNumber {
    public static int[] get(int[] number) {
        if (number == null) {
            return null;
        }
        int n = number.length;
        if (n == 0 || n == 1) {
            return number;
        }
        if (n == 2) {
            if (number[0] < number[1]) {
                int tmp = number[0];
                number[0] = number[1];
                number[1] = tmp;
            }
            return number;
        }

        // 找到逆序区域开始下标
        int startOfReversedField = n - 1;
        while (number[startOfReversedField - 1] >= number[startOfReversedField]) {
            startOfReversedField--;
        }
        // 如果没有逆序区域
        if (startOfReversedField == n - 1) {
            int tmp = number[n - 1];
            number[n - 1] = number[n - 2];
            number[n - 2] = tmp;
            return number;
        }
        // 如果已经是全排列中最大的数
        if (startOfReversedField == 1) {
            if (number[0] > number[1]) {
                return number;
            }
        }

        // 在逆序区域找到大于逆序区域前一个数且最小的值
        int min = Integer.MAX_VALUE;
        int minIndex = startOfReversedField;
        for (int i = startOfReversedField; i < n; i++) {
            if (number[i] > number[startOfReversedField - 1] && number[i] < min) {
                min = number[i];
                minIndex = i;
            }
        }

        // 交换逆序区域前一个数和上述最小值
        int tmp = number[minIndex];
        number[minIndex] = number[startOfReversedField - 1];
        number[startOfReversedField - 1] = tmp;

        // 逆序区域变为有序
        Arrays.sort(number, startOfReversedField, n);

        return number;
    }
}
