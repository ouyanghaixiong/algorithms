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
        tail.next = head;
    }

    public int getCycleEntry() {
        Node fast = head;
        Node slow = head;

        boolean met = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                met = true;
                break;
            }
        }

        if (met) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast.data;
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

    public int getCycleLength() {
        Node fast = head;
        Node slow = head;

        int step = 0;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            step++;
            if (fast == slow) {
                return step;
            }
        }

        return 0;
    }
}
