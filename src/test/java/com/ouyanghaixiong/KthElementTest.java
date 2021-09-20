package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class KthElementTest {

    @Test
    public void adjust() {
        int[] arr1 = {7, 5, 15, 3, 17};
        KthElement.adjust(arr1, 0, arr1.length);
        assertEquals("[5, 3, 15, 7, 17]", Arrays.toString(arr1));

        int[] arr2 = {7};
        KthElement.adjust(arr2, 0, arr2.length);
        assertEquals("[7]", Arrays.toString(arr2));

        int[] arr3 = {7, 5};
        KthElement.adjust(arr3, 0, arr3.length);
        assertEquals("[5, 7]", Arrays.toString(arr3));

        int[] arr4 = {};
        KthElement.adjust(arr4, 0, arr4.length);
        assertEquals("[]", Arrays.toString(arr4));
    }

    @Test
    public void buildHeap() {
        int[] arr = {7, 5, 15, 3, 17};
        KthElement.buildHeap(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void getByHeap() {
        int[] arr = {7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        assertEquals(12, KthElement.getByHeap(arr, 5));
        assertEquals(24, KthElement.getByHeap(arr, 1));
    }

    @Test
    public void partition() {
        int[] arr1 = {7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        assertEquals(6, KthElement.partition(arr1, 0, arr1.length));

        int[] arr2 = {0, 1, 2, 3, 4, 5};
        assertEquals(0, KthElement.partition(arr2, 0, arr2.length));

        int[] arr3 = {0};
        assertEquals(0, KthElement.partition(arr3, 0, arr3.length));

        int[] arr4 = {1, 2};
        assertEquals(0, KthElement.partition(arr4, 0, arr4.length));

        int[] arr5 = {5, 4, 3, 2, 1, 0};
        assertEquals(5, KthElement.partition(arr5, 0, arr5.length));

        int[] arr6 = {7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        assertEquals(3, KthElement.partition(arr6, 1, 4));
    }

    @Test
    public void getByPartition() {
        int[] arr1 = {7, 5, 15, 3, 17, 2, 20, 24, 1, 9, 12, 8};
        assertEquals(12, KthElement.getByPartition(arr1, 5));
    }
}
