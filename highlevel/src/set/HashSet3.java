package set;

import map.HashMap;

import java.util.Arrays;

// 解决哈希冲突：链表法
public class HashSet3<E> implements Set<E> {
    private class Node<E> {
        E e;
        Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<E>[] data;
    private int size;
    private double loadFactor = 0.75;

    public HashSet3(int capacity) {
        this.data = new Node[capacity];
        this.size = 0;
    }

    public HashSet3() {
        this(10);
    }

    private int hash(E e, int length) {
        return Math.abs(e.hashCode()) % length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        Node<E>[] newData = new Node[newCapacity];
        for (int i = 0; i < data.length; i++) {
            Node<E> curr = data[i];
            while (curr != null) {
                E e = curr.e;
                int newIndex = hash(e, newCapacity);
                Node<E> head = newData[newIndex];
                newData[newIndex] = new Node(e);
                // resize 往表头添加节点
                if (head != null) {
                    newData[newIndex].next = head;
                }
                curr = curr.next;
            }
        }
        data = newData;
    }

    @Override
    public void add(E e) { // O(1)
        int index = hash(e, data.length);
        Node<E> curr = data[index];
        while (curr != null) {
            if (curr.e.equals(e)) {
                return;
            }
            curr = curr.next;
        }
        // add 往表头添加新节点
        data[index] = new Node(e, data[index]);
        size++;
        if (size >= data.length * loadFactor) {
            resize(2 * data.length);
        }
    }

    public void add1(E e) { // O(1)
        int index = hash(e, data.length);
        if (data[index] == null) {
            data[index] = new Node(e);
        } else {
            Node<E> prev = null;
            Node<E> curr = data[index];
            while (curr != null) {
                if (e.equals(curr.e)) {
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            // add 往表尾添加新节点
            prev.next = new Node(e);
        }
        size++;
        if (size >= data.length * loadFactor) {
            resize(2 * data.length);
        }
    }

    @Override
    public void remove(E e) { // O(1)
        int index = hash(e, data.length);
        if (data[index] == null) return;
        Node<E> prev = null;
        Node<E> curr = data[index];
        while (curr != null) {
            if (e.equals(curr.e)) {
                if (prev == null) {
                    // 删除头节点
                    data[index] = curr.next;
                } else {
                    // 删除非头节点
                    prev.next = curr.next;
                }
                curr.next = null;
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    @Override
    public boolean contains(E e) { // O(1)
        int index = hash(e, data.length);
        if (data[index] == null) return false;
        Node<E> curr = data[index];
        while (curr != null) {
            if (e.equals(curr.e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return "HashSet3{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", loadFactor=" + loadFactor +
                '}';
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet3<>();
        set.add(0);
        set.add(1);
        set.remove(0);
        set.remove(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        set.remove(3);
        set.add(4);
        set.add(5);
        set.remove(4);
        set.remove(5);
        set.add(10);
        set.add(11);
        set.add(20);
        set.add(21);
        System.out.println(set);
    }
}
