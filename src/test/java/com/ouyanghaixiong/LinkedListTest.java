package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/28
 * @desc
 */
public class LinkedListTest {

    @Test
    public void insert() {
        LinkedList list = new LinkedList();
        list.insert(0, 0);
        list.insert(1, 1);
        list.insert(2, 2);
        assertEquals(3, list.size);
    }

    @Test
    public void add() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.size);
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(4);
        assertEquals(4, list.size);
    }

    @Test
    public void delete() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(3, list.size);
        list.delete(0);
        assertEquals(2, list.size);
    }

    @Test
    public void pop() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(2, list.pop());
        assertEquals(1, list.pop());
        assertEquals(0, list.pop());
    }

    @Test
    public void update() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        list.update(1, 100);
        assertEquals(100, list.search(1));
    }

    @Test
    public void search() {
        LinkedList list = new LinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        assertEquals(2, list.search(2));
    }
}
