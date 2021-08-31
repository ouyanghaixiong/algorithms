package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/29
 * @desc
 */
public class CyclicQueueTest {

    @Test
    public void enQueue() {
        MyCyclicQueue queue = new MyCyclicQueue(10);
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        assertEquals(4, queue.size);
    }

    @Test
    public void deQueue() {
        MyCyclicQueue queue = new MyCyclicQueue(10);
        queue.enQueue(0);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.deQueue();
        queue.deQueue();
        assertEquals(2, queue.size);
    }
}
