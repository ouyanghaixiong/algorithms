package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/12
 * @desc
 */
public class AVLTree {
    public static class Node {
        public int data;
        public Node left;
        public Node right;
        public int height = 1;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, int height) {
            this.data = data;
            this.height = height;
        }
    }

    public Node root;

    public AVLTree(int value) {
        this.root = new Node(value, 1);
    }

    private void updateHeight(Node node) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = node.left.height;
        }
        if (node.right != null) {
            rightHeight = node.right.height;
        }

        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private int getBalanceFactor(Node node) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = node.left.height;
        }
        if (node.right != null) {
            rightHeight = node.right.height;
        }

        return leftHeight - rightHeight;
    }

    /**
     * 左左局面
     *
     * @param node 根节点
     * @return 根节点
     */
    private Node ll(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    /**
     * 右右局面
     *
     * @param node 根节点
     * @return 根节点
     */
    private Node rr(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    /**
     * 左右局面
     *
     * @param node 根节点
     * @return 根节点
     */
    private Node lr(Node node) {
        node = rr(node);
        return ll(node);
    }

    /**
     * 右左局面
     *
     * @param node 根节点
     * @return 根节点
     */
    private Node rl(Node node) {
        node = ll(node);
        return rr(node);
    }

    public void add(int value) {
        root = addRecur(root, value);
    }

    /**
     * 增
     *
     * @param root  根节点
     * @param value 插入值
     * @return 根节点
     */
    private Node addRecur(Node root, int value) {
        if (root == null) {
            return new Node(value, 1);
        }

        if (value == root.data) {
            return root;
        } else if (value < root.data) {
            root.left = addRecur(root.left, value);
            updateHeight(root);
            if (getBalanceFactor(root) == 2) {
                if (value < root.left.data) {
                    return ll(root);
                }
                return lr(root);
            }
        } else {
            root.right = addRecur(root.right, value);
            updateHeight(root);
            if (getBalanceFactor(root) == -2) {
                if (value > root.right.data) {
                    return rr(root);
                }
                return rl(root);
            }
        }

        return root;
    }

    public void remove(int value) {
        root = removeRecur(root, value);
    }

    private Node removeRecur(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (root.data == value) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left != null && root.right != null) {
                Node cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.data = cur.data;
                removeRecur(cur, cur.data);
                updateHeight(root);
                if (getBalanceFactor(root) == 2) {
                    if (value > root.right.data) {
                        rr(root);
                    } else {
                        rl(root);
                    }
                }
                return root;
            }
            if (root.left != null) {
                root = root.left;
                updateHeight(root);
                if (getBalanceFactor(root) == -2) {
                    if (value < root.left.data) {
                        ll(root);
                    } else {
                        lr(root);
                    }
                }
            } else {
                root = root.right;
                updateHeight(root);
                if (getBalanceFactor(root) == 2) {
                    if (value > root.right.data) {
                        rr(root);
                    } else {
                        rl(root);
                    }
                }
            }
            return root;
        }

        if (value < root.data) {
            root.left =  removeRecur(root.left, value);
        } else {
            root.right = removeRecur(root.right, value);
        }

        return root;
    }
}
