package com.ouyanghaixiong;

import java.util.Stack;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class QueueImplementedByStack {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    public int size;

    public QueueImplementedByStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        size = 0;
    }

    public void enqueue(int value) {
        stack1.push(value);
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("The queue is empty.");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        Integer value = stack2.pop();
        size--;

        return value;
    }
}
