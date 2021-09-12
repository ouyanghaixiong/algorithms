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

    public void add(TreeNode root, int value) {
        // base case
        if (root.left == null && root.right == null) {
            if (value < root.data) {
                root.left = new TreeNode(value);
            } else {
                root.right = new TreeNode(value);
            }
            return;
        } else if (root.right == null && value >= root.data) {
            root.right = new TreeNode(value);
            return;
        } else if (root.left == null && value < root.data) {
            root.left = new TreeNode(value);
            return;
        }

        if (value < root.data) {
            add(root.left, value);
        } else {
            add(root.right, value);
        }
    }

    /**
     * 删除指定节点并返回根节点
     * @param root
     * @param value
     * @return
     */
    public TreeNode remove(TreeNode root, int value) {
        if (root.data == value) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left != null && root.right != null) {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.data = cur.data;
                remove(cur, cur.data);
                return root;
            }
            if (root.left != null) {
                return root.left;
            }
            return root.right;
        }

        if (value < root.data) {
            root.left = remove(root.left, value);
        } else {
            root.right = remove(root.right, value);
        }

        return root;
    }

    /**
     * 找到并返回指定节点
     * @param root
     * @param value
     * @return
     */
    public TreeNode get(TreeNode root, int value) {
        if (root == null) return null;

        if (value == root.data) {
            return root;
        } else if (value < root.data) {
            return get(root.left, value);
        } else {
            return get(root.right, value);
        }
    }
}
