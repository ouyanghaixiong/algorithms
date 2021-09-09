package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/9
 * @desc
 */
public class MyLRUTest {

    @Test
    public void put() {
        MyLRU lru = new MyLRU(10);
        lru.put("apple", 0);
        lru.put("banana", 1);
        lru.put("cat", 2);
        assertEquals(3, lru.size);
        assertEquals(0, lru.head.value);
        assertEquals(2, lru.tail.value);
    }

    @Test
    public void remove() {
        MyLRU lru = new MyLRU(10);
        lru.put("apple", 0);
        lru.put("banana", 1);
        lru.put("cat", 2);
        lru.remove("apple");
        assertEquals(2, lru.size);
        assertEquals(1, lru.head.value);
        assertEquals(2, lru.tail.value);
        assertFalse(lru.remove("fox"));
        assertTrue(lru.remove("cat"));
        assertEquals(1, lru.size);
        assertEquals(1, lru.head.value);
        assertEquals(1, lru.tail.value);
        assertTrue(lru.remove("banana"));
        assertEquals(0, lru.size);
        assertNull(lru.head);
        assertNull(lru.tail);
        lru.put("egg", 4);
        assertEquals(1, lru.size);
    }

    @Test
    public void get() {
        MyLRU lru = new MyLRU(10);
        lru.put("apple", 0);
        lru.put("banana", 1);
        lru.put("cat", 2);
        assertEquals(1, (int) lru.get("banana"));
        assertEquals(1, (int) lru.tail.value);
        assertEquals(0, (int) lru.head.value);
        lru.put("dog", 3);
        assertEquals(3, lru.tail.value);
        assertEquals(0, lru.head.value);
    }
}
