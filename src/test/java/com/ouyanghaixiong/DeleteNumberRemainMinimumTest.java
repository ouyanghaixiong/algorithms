package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/6
 * @desc
 */
public class DeleteNumberRemainMinimumTest {

    @Test
    public void get() {
        Integer[] values1 = {3, 5, 4, 9};
        assertEquals("[3, 4]", Arrays.toString(DeleteNumberRemainMinimum.get(values1, 2)));
        Integer[] values2 = {3, 5, 2};
        assertEquals("[2]", Arrays.toString(DeleteNumberRemainMinimum.get(values2, 2)));
        Integer[] values3 = {9, 2};
        assertEquals("[0]", Arrays.toString(DeleteNumberRemainMinimum.get(values3, 2)));
        Integer[] values4 = {1, 2, 3, 4, 5};
        assertEquals("[1, 2, 3, 4]", Arrays.toString(DeleteNumberRemainMinimum.get(values4, 1)));
        Integer[] values5 = {1, 2, 3, 4, 5};
        assertEquals("[1, 2, 3]", Arrays.toString(DeleteNumberRemainMinimum.get(values5, 2)));
    }
}
