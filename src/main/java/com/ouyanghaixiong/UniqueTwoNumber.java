package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/6
 * @desc
 */
public class UniqueTwoNumber {
    public static int[] find(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        int[] res = new int[2];
        int n = numbers.length;
        if (n == 0) {
            return res;
        }

        // 求所有数的异或
        int xorOfNumbers = 0;
        for (int number : numbers) {
            xorOfNumbers ^= number;
        }

        // 找上值的任何为1的一位
        int selector = 1;
        while ((selector & xorOfNumbers) == 0) {
            selector <<= 1;
        }

        // 按照这位重新将numbers分为两类, 一类这位为0, 一类这位为1
        // 两类分别求异或, 分别剩下只出现奇数次的数字
        for (int number : numbers) {
            if ((number&selector) == 0) {
                res[0] = res[0] ^ number;
            } else {
                res[1] =  res[1] ^ number;
            }
        }

        return res;
    }
}
