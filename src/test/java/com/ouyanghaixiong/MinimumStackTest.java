package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class MinimumStackTest {

    @Test
    public void push() {
        MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(3);
        minimumStack.push(5);
        minimumStack.push(2);
        minimumStack.push(1);
        minimumStack.push(9);
        assertEquals(5, minimumStack.size);
    }

    @Test
    public void pop() {
        MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(3);
        minimumStack.push(5);
        minimumStack.push(2);
        minimumStack.push(1);
        minimumStack.push(9);
        assertEquals(9, minimumStack.pop());
        assertEquals(1, minimumStack.pop());
        assertEquals(2, minimumStack.pop());
    }

    @Test
    public void getMin() {
        MinimumStack minimumStack = new MinimumStack();
        minimumStack.push(3);
        minimumStack.push(5);
        minimumStack.push(2);
        minimumStack.push(1);
        minimumStack.push(9);
        assertEquals(1, minimumStack.getMin());
        minimumStack.pop();
        minimumStack.pop();
        assertEquals(2, minimumStack.getMin());
    }
}
