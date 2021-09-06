package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class QueueImplementedByStackTest {

    @Test
    public void enqueue() {
        QueueImplementedByStack q = new QueueImplementedByStack();
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        assertEquals(3, q.size);
    }

    @Test
    public void dequeue() {
        QueueImplementedByStack q = new QueueImplementedByStack();
        q.enqueue(3);
        q.enqueue(5);
        q.enqueue(7);
        assertEquals(3, q.dequeue());
        assertEquals(2, q.size);
        assertEquals(5, q.dequeue());
        assertEquals(1, q.size);
        assertEquals(7, q.dequeue());
        assertEquals(0, q.size);
    }
}
