package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/6
 * @desc
 */
public class UniqueTwoNumberTest {

    @Test
    public void find() {
        int[] numbers = {1,1,2,2,3,4,4,5,5,5};
        assertEquals("[5, 3]", Arrays.toString(UniqueTwoNumber.find(numbers)));
    }
}
