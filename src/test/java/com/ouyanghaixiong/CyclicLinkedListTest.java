package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/4
 * @desc
 */
public class CyclicLinkedListTest {

    @Test
    public void getCycleEntry() {
        CyclicLinkedList list = new CyclicLinkedList(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals(0, list.getCycleEntry());
    }

    @Test
    public void isCyclic() {
        CyclicLinkedList list1 = new CyclicLinkedList(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        assertTrue(list1.isCyclic());

        CyclicLinkedList list2 = new CyclicLinkedList(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        assertTrue(list2.isCyclic());
    }

    @Test
    public void add() {
        CyclicLinkedList list = new CyclicLinkedList(0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(4, list.size);
    }

    @Test
    public void getCycleLength() {
        CyclicLinkedList list = new CyclicLinkedList(0);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(4, list.getCycleLength());
    }
}
