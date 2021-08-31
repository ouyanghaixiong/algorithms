package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/29
 * @desc
 */
public class MyCyclicQueue {
    private final int[] arr;
    private final int capacity;
    public int size;
    private int front;
    private int rear;

    public MyCyclicQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    public void enQueue(int data) {
        if ((rear + 1) % capacity == front) {
            throw new RuntimeException("There is no space left in the queue.");
        }

        arr[rear] = data;
        size++;
        rear = (rear + 1) % capacity;
    }

    public int deQueue() {
        if (front == rear) {
            throw new RuntimeException("The queue is empty.");
        }

        int data = arr[front];
        size--;
        front = (front + 1) % capacity;

        return data;
    }
}
