package com.ouyanghaixiong;

import com.sun.xml.internal.xsom.impl.SchemaImpl;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/1
 * @desc
 */
public class MinimumHeap {
    public Integer[] arr;
    private final int capacity;
    public int size;

    public MinimumHeap(int capacity) {
        this.capacity = capacity;
        this.arr = new Integer[capacity];
        this.size = 0;
    }

    public void push(int value) {
        int curIndex = size;
        this.arr[curIndex] = value;
        while (curIndex > 0) {
            int parentIndex = (curIndex - 1) / 2;
            if (this.arr[curIndex] >= this.arr[parentIndex]) {
                break;
            }
            this.arr[curIndex] = this.arr[parentIndex];
            curIndex = parentIndex;
        }
        this.arr[curIndex] = value;
        size++;
    }

    public int pop() {
        int value = this.arr[0];
        int tmp = this.arr[size - 1];
        this.arr[0] = tmp;
        this.arr[size - 1] = null;
        int curIndex = 0;
        size--;
        while (true) {
            if (curIndex * 2 + 1 > size - 1) {
                break;
            }
            int childIndex = curIndex * 2 + 1;
            if (childIndex + 1 <= size - 1 && this.arr[childIndex] > this.arr[childIndex + 1]) {
                childIndex++;
            }
            if (tmp <= this.arr[childIndex]) {
                break;
            }

            this.arr[curIndex] = this.arr[childIndex];
            curIndex = childIndex;
        }
        this.arr[curIndex] = tmp;

        return value;
    }

    public void build(int[] values) {
        for (int value : values) {
            push(value);
        }
    }
}
