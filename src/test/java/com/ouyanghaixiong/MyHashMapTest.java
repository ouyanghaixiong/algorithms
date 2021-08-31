package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/29
 * @desc
 */
public class MyHashMapTest {

    @Test
    public void put() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("apple", 0);
        myHashMap.put("banana", 1);
        myHashMap.put("cat", 2);
        System.out.println(myHashMap.size);
    }

    @Test
    public void get() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("apple", 0);
        myHashMap.put("banana", 1);
        myHashMap.put("cat", 2);
        assertEquals(0, myHashMap.get("apple", 100));
        assertEquals(1, myHashMap.get("banana", 100));
        assertEquals(2, myHashMap.get("cat", 100));
    }
}
