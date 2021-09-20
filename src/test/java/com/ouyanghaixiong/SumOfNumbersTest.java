package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class SumOfNumbersTest {
    int[] arr;

    @Before
    public void setUp() throws Exception {
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Test
    public void getTwoSum() {
        int[][] res = SumOfNumbers.getTwoSum(arr, 0, arr.length, 11);
        assertEquals("[[1, 10], [2, 9], [3, 8], [4, 7], [5, 6]]", Arrays.deepToString(res));
        res = SumOfNumbers.getTwoSum(arr, 8, arr.length, 19);
        assertEquals("[[9, 10]]", Arrays.deepToString(res));
        res = SumOfNumbers.getTwoSum(arr, 9, arr.length, 19);
        assertNull(res);
        res = SumOfNumbers.getTwoSum(arr, 10, arr.length, 19);
        assertNull(res);
    }

    @Test
    public void getThreeSum() {
        int[][] res = SumOfNumbers.getThreeSum(arr, 9);
        assertEquals("[[1, 2, 6], [1, 3, 5], [2, 3, 4]]", Arrays.deepToString(res));
    }
}
