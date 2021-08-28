package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/5/12
 * @desc
 */
public class ArrayListTest {
    private ArrayList list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds() {
        list.insert(1, 1);
    }

    @Test
    public void testInsert() {
        list.insert(0,0);
        assertEquals(1, list.getSize());
        list.insert(1,1);
        assertEquals(2, list.getSize());
        list.insert(1,1);
        assertEquals(3, list.getSize());
        list.insert(3, 3);
        assertEquals(4, list.getSize());
        assertEquals(6,list.getCapacity());
    }

    @Test
    public void testAdd() {
        list.add(10);
        assertEquals(1, list.getSize());
        assertEquals(3, list.getCapacity());
        list.add(100);
        list.add(1000);
        list.add(10000);
        list.add(100000);
        assertEquals(5, list.getSize());
        assertEquals(6, list.getCapacity());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds() {
        list.remove(0);
    }

    @Test
    public void testRemove() {
        list.add(0);
        list.remove(0);
        assertEquals(0, list.getSize());
        list.add(1);
        list.add(2);
        int removed = list.remove(1);
        assertEquals(1, list.getSize());
        assertEquals(2, removed);
    }

    @Test
    public void testSet() {
        list.add(0);
        list.set(0,1);
        assertEquals(1,list.get(0));
    }

    @Test
    public void testGet() {
        list.add(0);
        list.add(1);
        assertEquals(1, list.get(1));
    }
}
