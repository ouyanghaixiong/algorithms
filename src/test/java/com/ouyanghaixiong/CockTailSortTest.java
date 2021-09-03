package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/2
 * @desc
 */
public class CockTailSortTest {

    @Test
    public void sort() {
        CockTailSort cockTailSort = new CockTailSort();
        int [] values = {3, 5, 7, 8, 9, 2, 19, 200};
        cockTailSort.sort(values);
        assertEquals("[2, 3, 5, 7, 8, 9, 19, 200]", Arrays.toString(values));
    }
}
