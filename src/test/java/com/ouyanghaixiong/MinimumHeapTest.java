package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/1
 * @desc
 */
public class MinimumHeapTest {
    private MinimumHeap heap;

    @Before
    public void setUp() throws Exception {
        this.heap = new MinimumHeap(100);
    }

    @Test
    public void push() {
        int[] values = {7, 1, 5, 2, 3, 6, 4};
        this.heap.build(values);
        this.heap.push(10);
        this.heap.push(11);
        this.heap.push(19);
        this.heap.push(26);
        assertEquals(11, this.heap.size);
    }

    @Test
    public void pop() {
        int[] values = {7, 1, 5, 2, 3, 6, 4};
        this.heap.build(values);
        assertEquals(1, this.heap.pop());
        assertEquals(2, this.heap.pop());
        assertEquals(3, this.heap.pop());
        assertEquals(4, this.heap.pop());
        assertEquals(5, this.heap.pop());
        assertEquals(6, this.heap.pop());
        assertEquals(7, this.heap.pop());
    }

    @Test
    public void build() {
        int[] values = {7, 1, 5, 2, 3, 6, 4};
        this.heap.build(values);
        assertEquals(7, this.heap.size);
        System.out.println(Arrays.toString(this.heap.arr));
    }
}
