package com.ouyanghaixiong;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/12
 * @desc
 */
public class AVLTreeTest {

    @Test
    public void add() {
        AVLTree tree = new AVLTree(1);
        tree.add(2);
        tree.add(3);
        assertEquals(2, tree.root.data);
        assertEquals(1, tree.root.left.data);
        assertEquals(3, tree.root.right.data);
        tree.add(4);
        assertEquals(4, tree.root.right.right.data);
        tree.add(5);
        assertEquals(4, tree.root.right.data);
        assertEquals(3, tree.root.right.left.data);
        assertEquals(5, tree.root.right.right.data);
    }

    @Test
    public void remove() {
        AVLTree tree = new AVLTree(1);
        tree.add(2);
        tree.add(3);
        tree.remove(1);
        assertEquals(2, tree.root.data);
        assertNull(tree.root.left);
        assertEquals(3, tree.root.right.data);
        tree.remove(2);
        assertEquals(3, tree.root.data);
        assertNull(tree.root.left);
        assertNull(tree.root.right);
    }
}
