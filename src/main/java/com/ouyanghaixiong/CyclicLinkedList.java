package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/4
 * @desc
 */
public class CyclicLinkedList {
    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private final Node head;
    private Node tail;
    public int size;

    public CyclicLinkedList(int initData) {
        head = new Node(initData);
        tail = head;
        size = 1;
    }

    public void add(int data) {
        tail.next = new Node(data);
        tail = tail.next;
        size++;
    }

    public void addCyclicNode(int data) {
        tail.next = new Node(data);
        tail = tail.next;
        size++;
        tail.next = head;
    }

    public int getCycleEntry() {
        Node fast = head;
        Node slow = head;

        boolean melt = false;
        int count = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            count++;
            if (fast == slow) {
                melt = true;
                break;
            }
        }

        if (melt) {
            for (int i = 0; i < count; i++) {
                slow = slow.next;
            }
            return slow.data;
        }

        return -1;
    }

    public boolean isCyclic() {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
