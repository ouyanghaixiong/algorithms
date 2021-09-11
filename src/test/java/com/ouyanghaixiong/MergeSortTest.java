package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/11
 * @desc
 */
public class MergeSortTest {

    @Test
    public void sort() {
        int [] values1 = {5, 2, 3, 9, 10, 22};
        MergeSort.sort(values1);
        System.out.println(Arrays.toString(values1));
        assertEquals("[2, 3, 5, 9, 10, 22]", Arrays.toString(values1));
    }
}
