package com.ouyanghaixiong;

import java.util.*;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/31
 * @desc
 */
public class BinarySearchTree {
    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
        public boolean visited;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 以第一个节点为根节点构建二叉树
     *
     * @param treeNodes 节点列表
     * @return 二叉树根节点
     */
    public TreeNode buildTree(LinkedList<TreeNode> treeNodes) {
        if (treeNodes.isEmpty()) {
            return null;
        }

        TreeNode root = treeNodes.removeFirst();
        if (root == null) {
            return null;
        }
        root.left = buildTree(treeNodes);
        root.right = buildTree(treeNodes);

        return root;
    }

    public List<Integer> preOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                continue;
            }
            if (!cur.visited) {
                cur.visited = true;
                list.add(cur.data);
            }
            if (cur.left != null && !cur.left.visited) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            if (cur.right != null && !cur.right.visited) {
                stack.push(cur);
                cur = cur.right;
                continue;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                continue;
            }
            cur = null;
        }

        return list;
    }

    public List<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                continue;
            }
            if (cur.left == null || cur.left.visited) {
                if (!cur.visited) {
                    cur.visited = true;
                    list.add(cur.data);
                }
            }
            if (cur.left != null && !cur.left.visited) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            if (cur.right != null && !cur.right.visited) {
                stack.push(cur);
                cur = cur.right;
                continue;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                continue;
            }
            cur = null;
        }

        return list;
    }

    public List<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            if (cur == null) {
                cur = stack.pop();
                continue;
            }
            if ((cur.left == null || cur.left.visited) && (cur.right == null || cur.right.visited)) {
                if (!cur.visited) {
                    cur.visited = true;
                    list.add(cur.data);
                }
            }
            if (cur.left != null && !cur.left.visited) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            if (cur.right != null && !cur.right.visited) {
                stack.push(cur);
                cur = cur.right;
                continue;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                continue;
            }
            cur = null;
        }

        return list;
    }

    public List<Integer> bfs(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }

        return list;
    }
}
