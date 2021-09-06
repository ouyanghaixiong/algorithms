package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class MaxOrderedIntervalTest {

    @Test
    public void get() {
        int[] values1 = {2, 6, 3, 4, 5, 10, 9};
        assertEquals(3, MaxOrderedInterval.get(values1));
        int[] values2 = {2, 100, 1000};
        assertEquals(900, MaxOrderedInterval.get(values2));
    }
}
