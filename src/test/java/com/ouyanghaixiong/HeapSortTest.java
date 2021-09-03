package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/3
 * @desc
 */
public class HeapSortTest {

    @Test
    public void adjust() {
        HeapSort heapSort = new HeapSort();
        int[] values1 = {1, 8, 9, 7, 5, 6, 4, 3, 2};
        heapSort.adjust(values1, 0, values1.length);
        System.out.println(Arrays.toString(values1));
        int[] values2 = {1, 5, 9, 8, 6, 7};
        heapSort.adjust(values2, 1, 3);
        System.out.println(Arrays.toString(values2));
    }

    @Test
    public void sort() {
        int[] values = {1, 8, 9, 7, 5, 4, 6, 3, 2};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(values);
        System.out.println(Arrays.toString(values));
    }
}
