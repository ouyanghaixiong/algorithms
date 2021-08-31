package com.ouyanghaixiong;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/31
 * @desc
 */
public class NonRecursivePreOrderTest {
    private LinkedList<NonRecursivePreOrder.TreeNode> treeNodes;
    private NonRecursivePreOrder nonRecursivePreOrder;

    @Before
    public void setUp() throws Exception {
        treeNodes = new LinkedList<>();
        treeNodes.add(new NonRecursivePreOrder.TreeNode(1));
        treeNodes.add(new NonRecursivePreOrder.TreeNode(2));
        treeNodes.add(new NonRecursivePreOrder.TreeNode(4));
        treeNodes.add(new NonRecursivePreOrder.TreeNode(7));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(new NonRecursivePreOrder.TreeNode(8));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(new NonRecursivePreOrder.TreeNode(5));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(new NonRecursivePreOrder.TreeNode(3));
        treeNodes.add(new NonRecursivePreOrder.TreeNode(6));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(null);
        nonRecursivePreOrder = new NonRecursivePreOrder();
    }

    @Test
    public void buildTree() {
        NonRecursivePreOrder.TreeNode treeNode = nonRecursivePreOrder.buildTree(treeNodes);
        assertEquals(1, treeNode.data);
        assertEquals(2, treeNode.left.data);
        assertEquals(3, treeNode.right.data);
    }

    @Test
    public void preOrder() {
        NonRecursivePreOrder.TreeNode treeNode = nonRecursivePreOrder.buildTree(treeNodes);
        List<Integer> list = nonRecursivePreOrder.preOrder(treeNode);
        list.forEach(System.out::println);
    }

    @Test
    public void inOrder() {
        NonRecursivePreOrder.TreeNode treeNode = nonRecursivePreOrder.buildTree(treeNodes);
        List<Integer> list = nonRecursivePreOrder.inOrder(treeNode);
        list.forEach(System.out::println);
    }

    @Test
    public void postOrder() {
        NonRecursivePreOrder.TreeNode treeNode = nonRecursivePreOrder.buildTree(treeNodes);
        List<Integer> list = nonRecursivePreOrder.postOrder(treeNode);
        list.forEach(System.out::println);
    }
}
