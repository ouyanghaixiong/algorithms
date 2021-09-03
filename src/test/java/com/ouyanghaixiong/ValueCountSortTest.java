package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/3
 * @desc
 */
public class ValueCountSortTest {

    @Test
    public void sort() {
        int [] values = {5, 2, 3, 9, 10, 22};
        ValueCountSort valueCountSort = new ValueCountSort();
        valueCountSort.sort(values);
        System.out.println(Arrays.toString(values));
    }
}
