package com.ouyanghaixiong;

import java.util.Objects;
import java.util.Stack;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/5
 * @desc
 */
public class MinimumStack {
    private final Stack<Integer> a;
    private final Stack<Integer> b;
    public int size;

    public MinimumStack() {
        a = new Stack<>();
        b = new Stack<>();
        size = 0;
    }

    public void push(int value) {
        if (size == 0) {
            a.push(value);
            b.push(value);
        } else {
            if (value < getMin()) {
                a.push(value);
                b.push(value);
            } else {
                a.push(value);
            }
        }
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("The stack is empty.");
        }

        Integer value = a.pop();
        if (Objects.equals(value, b.peek())) {
            b.pop();
        }
        size--;

        return value;
    }

    public int getMin() {
        if (size == 0) {
            throw new RuntimeException("The stack is empty.");
        }

        return b.peek();
    }
}
