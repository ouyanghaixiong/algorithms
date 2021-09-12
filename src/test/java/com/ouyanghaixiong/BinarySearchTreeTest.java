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
public class BinarySearchTreeTest {
    private LinkedList<BinarySearchTree.TreeNode> treeNodes;
    private BinarySearchTree bst;

    @Before
    public void setUp() throws Exception {
        treeNodes = new LinkedList<>();
        treeNodes.add(new BinarySearchTree.TreeNode(6));
        treeNodes.add(new BinarySearchTree.TreeNode(4));
        treeNodes.add(new BinarySearchTree.TreeNode(2));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(new BinarySearchTree.TreeNode(5));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(new BinarySearchTree.TreeNode(8));
        treeNodes.add(new BinarySearchTree.TreeNode(7));
        treeNodes.add(null);
        treeNodes.add(null);
        treeNodes.add(new BinarySearchTree.TreeNode(9));
        treeNodes.add(null);
        treeNodes.add(null);
        bst = new BinarySearchTree();
    }

    @Test
    public void buildTree() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        assertEquals(6, root.data);
        assertEquals(4, root.left.data);
        assertEquals(8, root.right.data);
        assertEquals(2, root.left.left.data);
        assertEquals(5, root.left.right.data);
        assertEquals(7, root.right.left.data);
        assertEquals(9, root.right.right.data);
    }

    @Test
    public void preOrder() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        List<Integer> list = bst.preOrder(root);
        list.forEach(System.out::println);
    }

    @Test
    public void inOrder() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        List<Integer> list = bst.inOrder(root);
        list.forEach(System.out::println);
    }

    @Test
    public void postOrder() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        List<Integer> list = bst.postOrder(root);
        list.forEach(System.out::println);
    }

    @Test
    public void bfs() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        List<Integer> list = bst.bfs(root);
        list.forEach(System.out::println);
    }

    @Test
    public void add() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        bst.add(root, 15);
        bst.inOrder(root).forEach(System.out::println);
    }

    @Test
    public void remove() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        assertEquals(4, root.left.data);
        root = bst.remove(root, 4);
        assertEquals(5, root.left.data);
        root = bst.remove(root, 8);
        assertEquals(9, root.right.data);
        root = bst.remove(root, 7);
        assertEquals(9, root.right.data);
    }

    @Test
    public void get() {
        BinarySearchTree.TreeNode root = bst.buildTree(treeNodes);
        BinarySearchTree.TreeNode node = bst.get(root, 8);
        assertEquals(8, node.data);
    }
}
