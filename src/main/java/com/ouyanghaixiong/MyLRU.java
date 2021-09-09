package com.ouyanghaixiong;

/**
 * @author ouyanghaixiong@forchange.tech
 * @date 2021/9/9
 * @desc
 */
public class MyLRU {
    protected static class ListNode {
        public String key;
        public int value;
        public ListNode prev;
        public ListNode next;
        public ListNode hnext;

        public ListNode() {
        }

        public ListNode(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public ListNode head;
    public ListNode tail;

    private final ListNode[] arr;
    private final int capacity;
    public int size;

    public MyLRU(int capacity) {
        this.capacity = capacity;
        this.arr = new ListNode[16];
        this.size = 0;
    }

    public void put(String key, int value) {
        // 先判断队列中是否已有此元素, 如果已经有了, 更新值, 将该节点变为列表尾, 否则
        ListNode listNode = exist(key);
        if (listNode != null) {
            moveToTailInBinaryList(listNode);
            listNode.value = value;
            return;
        }

        // 如果队列已满, 删除对头元素, size--
        if (size == capacity) {
            deleteNodeInBinaryList(head);
            size--;
        }

        // 在队尾插入新元素, size++
        int index = findIndex(key);
        ListNode cur = this.arr[index];
        ListNode newNode = new ListNode(key, value);
        if (cur == null) {
            this.arr[index] = newNode;
        } else {
            while (cur.hnext != null) {
                cur = cur.hnext;
            }
            cur.hnext = newNode;
        }
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public boolean remove(String key) {
        // 找该节点
        int index = findIndex(key);
        ListNode listNode = this.arr[index];
        if (listNode == null) {
            return false;
        }
        ListNode hprev = null;
        while (!listNode.key.equals(key)) {
            hprev = listNode;
            listNode = listNode.hnext;
            if (listNode == null) {
                return false;
            }
        }
        if (hprev == null) {
            this.arr[index] = null;
        } else {
            hprev.next = listNode.next;
        }
        deleteNodeInBinaryList(listNode);
        size--;

        return true;
    }

    public Integer get(String key) {
        int index = findIndex(key);
        ListNode listNode = this.arr[index];

        // 如果头结点==null, 返回null
        if (listNode == null) {
            return null;
        }

        // 遍历链表, 逐一查看元素key是否一致, 如果一致, 将该节点变为尾节点, 返回value
        while (listNode != null) {
            if (!listNode.key.equals(key)) {
                listNode = listNode.hnext;
                continue;
            }

            deleteNodeInBinaryList(listNode);
            moveToTailInBinaryList(listNode);

            return listNode.value;
        }

        return null;
    }

    private int findIndex(String key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

    private ListNode exist(String key) {
        int index = findIndex(key);
        ListNode listNode = this.arr[index];
        if (listNode == null) {
            return null;
        }
        while (listNode != null) {
            if (listNode.key.equals(key)) {
                return listNode;
            }
            listNode = listNode.next;
        }

        return null;
    }

    private void deleteNodeInBinaryList(ListNode listNode) {
        if (listNode == head && listNode == tail) {
            head = tail = null;
            return;
        }

        if (listNode == tail) {
            listNode.prev.next = null;
            tail = listNode.prev;
            return;
        }

        if (listNode == head) {
            head = listNode.next;
            head.prev = null;
            return;
        }

        listNode.prev.next = listNode.next;
        listNode.next.prev = listNode.prev;
    }

    private void moveToTailInBinaryList(ListNode listNode) {
        listNode.prev = tail;
        tail.next = listNode;
        listNode.next = null;
        tail = listNode;
    }
}
