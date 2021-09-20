package com.ouyanghaixiong;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/20
 * @desc
 */
public class KMPTest {

    @Test
    public void search() {
        assertEquals(4, KMP.search("acabacacba", "acacb"));
        assertEquals(0, KMP.search("a", "a"));
        assertEquals(-1, KMP.search("b", "a"));
        assertEquals(1, KMP.search("abc", "bc"));
        assertEquals(-1, KMP.search("abc", "mn"));
    }

    @Test
    public void getNext() {
        String p = "acacb";
        int[] next = KMP.getNext(p);
        System.out.println(Arrays.toString(next));
    }
}
