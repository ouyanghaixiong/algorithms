package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/2
 * @desc
 */
public class QuickSortTest {

    @Test
    public void partition() {
        int [] values1 = {5, 2, 3, 9, 10, 22};
        QuickSort quickSort = new QuickSort();
        Integer p1 = quickSort.partition(values1, 0, values1.length);
        System.out.println(Arrays.toString(values1));
        System.out.println(p1);

        int [] values2 = {5, 2, 3, 9, 10, 22};
        Integer p2 = quickSort.partition(values2, 2, 3);
        System.out.println(Arrays.toString(values2));
        System.out.println(p2);

        int [] values3 = {5, 2, 3, 9, 10, 22};
        Integer p3 = quickSort.partition(values3, 2, 2);
        System.out.println(Arrays.toString(values3));
        System.out.println(p3);
    }

    @Test
    public void sort() {
        int [] values1 = {5, 2, 3, 9, 10, 22};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(values1);
        System.out.println(Arrays.toString(values1));
    }
}