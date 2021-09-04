package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/4
 * @desc
 */
public class BucketSortTest {

    @Test
    public void sort() {
        int [] values = {5, 2, 3, 9, 10, 22};
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(values);
        assertEquals("[2, 3, 5, 9, 10, 22]", Arrays.toString(values));
    }
}
