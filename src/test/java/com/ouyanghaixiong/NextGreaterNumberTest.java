package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class NextGreaterNumberTest {

    @Test
    public void get() {
        int[] number1 = {7, 2, 5, 9, 6};
        assertEquals("[7, 2, 6, 5, 9]", Arrays.toString(NextGreaterNumber.get(number1)));

        int[] number2 = {3, 7, 1, 2, 5};
        assertEquals("[3, 7, 1, 5, 2]", Arrays.toString(NextGreaterNumber.get(number2)));

        int[] number3 = {3, 7, 1};
        assertEquals("[7, 1, 3]", Arrays.toString(NextGreaterNumber.get(number3)));

        int[] number4 = {7, 3};
        assertEquals("[7, 3]", Arrays.toString(NextGreaterNumber.get(number4)));

        int[] number5 = {7};
        assertEquals("[7]", Arrays.toString(NextGreaterNumber.get(number5)));
    }
}
