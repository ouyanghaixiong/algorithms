package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/5/12
 * @desc
 */
public class MyArrayList {
    private int[] arr;
    private int capacity;
    private int size;

    public MyArrayList(int capacity) {
        this.arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0");
        }

        if (index > size) {
            throw new IndexOutOfBoundsException("index > size");
        }

        if (size == capacity) {
            capacity = 2 * capacity;
            int[] newArr = new int[capacity];
            System.arraycopy(arr, 0, newArr, 0, size);
            arr = newArr;
        }

        if (size - index >= 0) {
            System.arraycopy(arr, index, arr, index + 1, size - index);
        }
        arr[index] = value;
        size++;
    }

    public void add(int value) {
        insert(size,value);
    }

    public int remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0");
        }

        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index > size - 1");
        }

        int removed = arr[index];
        size--;

        if (size - index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, size - index);
        }

        return removed;
    }

    public void set(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0");
        }

        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index > size");
        }

        arr[index] = value;
    }

    public int get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index < 0");
        }

        if (index > size - 1) {
            throw new IndexOutOfBoundsException("index > size - 1");
        }

        return arr[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
