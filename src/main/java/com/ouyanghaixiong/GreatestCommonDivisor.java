package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class GreatestCommonDivisor {
    public static int gcd(int a, int b) {
        if (a == 0 || b ==-0) {
            throw new IllegalArgumentException("a or b can not be zero.");
        }

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        // 终止条件: 小的数可以整除大的数, 说明不用再继续细分下去了
        if (max % min == 0) {
            return min;
        }

        // 如果两数均为偶数
        if ((max & 1) == 0 && (min & 1) == 0) {
            return 2 * gcd(max / 2, min / 2);
            // 如果一数为奇, 一数为偶
        } else if ((max & 1) == 0 && (min & 1) == 1) {
            return gcd(max / 2, min);
        } else if ((max & 1) == 1 && (min & 1) == 0) {
            return gcd(max, min / 2);
            // 如果两数为奇, 则max - min 为偶
        } else {
            return gcd(max - min, min);
        }
    }
}
