package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/28
 * @desc
 */
public class MyLinkedList {
    private static class Node {
        public Integer data;
        public Node prev;
        public Node next;

        public Node(Integer data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    public int size;

    public MyLinkedList() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    private Node get(int index) {
        if (index == -1) {
            return head;
        }

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        Node tmp = head;
        for (int i = 0; i <= index; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        Node prevNode = get(index - 1);
        Node nextNode = prevNode.next;
        Node inserted = new Node(data);
        prevNode.next = inserted;
        inserted.prev = prevNode;
        inserted.next = nextNode;
        nextNode.prev = inserted;
        size++;
    }

    public void add(int data) {
        Node prevNode = tail.prev;
        Node newNode = new Node(data);
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        Node prevNode = get(index - 1);
        prevNode.next = prevNode.next.next;
        size--;
    }

    public int pop() {
        if (size <= 0) {
            throw new NullPointerException("There is no element left in the list.");
        }

        Node targetNode = tail.prev;
        targetNode.prev.next = tail;
        tail.prev = targetNode.prev;

        size--;

        return targetNode.data;
    }

    public void update(int index, int data) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        Node curNode = get(index);
        curNode.data = data;
    }

    public int search(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Index out of bound.");
        }

        return get(index).data;
    }
}
