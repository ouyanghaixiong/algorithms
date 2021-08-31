package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/8/29
 * @desc
 */
public class MyHashMap {
    private static class Entry {
        public String key;
        public int value;
        public Entry next;

        public Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] arr;
    public int size;
    private int capacity;
    private static final double loadFactor = 0.75;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = initCapacity;
        this.arr = new Entry[initCapacity];
        this.size = 0;
    }

    public void put(String key, int value) {
        if (size >= capacity * loadFactor) {
            resize();
        }

        int index = Math.abs(key.hashCode()) % capacity;
        Entry entry = new Entry(key, value);
        if (arr[index] == null) {
            arr[index] = entry;
        } else {
            Entry cur = arr[index];
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = entry;
        }
        size++;
    }

    public int get(String key, int defaultValue) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (arr[index] == null) {
            return defaultValue;
        }

        Entry tmp = arr[index];

        if (tmp.key.equals(key)) {
            return tmp.value;
        }

        while (tmp.next != null) {
            tmp = tmp.next;
            if (tmp.key.equals(key)) {
                return tmp.value;
            }
        }

        return defaultValue;
    }

    private void resize() {
        this.capacity = this.capacity << 2;
        Entry[] newArr = new Entry[capacity];
        for (Entry entry : arr) {
            int newIndex = Math.abs(entry.key.hashCode()) % this.capacity;
            Entry newEntry = new Entry(entry.key, entry.value);
            if (newArr[newIndex] == null) {
                newArr[newIndex] = newEntry;
            } else {
                Entry cur = arr[newIndex];
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = entry;
            }
        }
        this.arr = newArr;
    }
}
