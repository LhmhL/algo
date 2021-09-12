package map;

import java.util.NoSuchElementException;

// 解决哈希冲突：链表法
public class HashMap<K, V> implements Map<K, V> {
    private class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }
    }

    private Node<K, V>[] data;
    private int size;
    private double loadFactor = 0.75;

    public HashMap(int Capacity) {
        this.data = new Node[Capacity];
        this.size = 0;
    }

    public HashMap() {
        this(10);
    }

    // 计算一个 key 对应的索引值
    private int hash(K key, int length) {
        return Math.abs(key.hashCode()) % length;
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
        Node<K, V>[] newData = new Node[newCapacity];
        for (int i = 0; i < data.length; i++) {
            Node<K, V> curr = data[i];
            while (curr != null) {
                K key = curr.key;
                int newIndex = hash(key, newCapacity);
                Node<K, V> head = newData[newIndex];
                newData[newIndex] = new Node(key, curr.value);
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
    public void add(K key, V value) { // O(1)
        int index = hash(key, data.length);
        Node<K, V> curr = getNode(key, index);
        if (curr == null) {
            // add 往表头添加新节点
            data[index] = new Node(key, value, data[index]);
            size++;
            if (size >= data.length * loadFactor) {
                resize(2 * data.length);
            }
        } else {
            curr.value = value;
        }
    }

    public void add1(K key, V value) { // O(1)
        int index = hash(key, data.length);
        if (data[index] == null) {
            data[index] = new Node(key, value);
            size++;
        } else {
            Node<K, V> prev = null;
            Node<K, V> curr = data[index];
            while (curr != null) {
                if (key.equals(curr.key)) {
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if (curr == null) {
                // add 往表尾添加新节点
                prev.next = new Node(key, value);
                size++;
            } else {
                curr.value = value;
            }
        }
        if (size >= data.length * loadFactor) {
            resize(2 * data.length);
        }
    }

    @Override
    public V remove(K key) { // O(1)
        int index = hash(key, data.length);
        if (data[index] == null) return null;
        Node<K, V> prev = null;
        Node<K, V> curr = data[index];
        while (curr != null) {
            if (key.equals(curr.key)) {
                if (prev == null) {
                    // 删除头节点
                    data[index] = curr.next;
                } else {
                    // 删除非头节点
                    prev.next = curr.next;
                }
                curr.next = null;
                size--;
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    private Node<K, V> getNode(K key, int index) { // O(1)
        Node<K, V> curr = data[index];
        while (curr != null) {
            if (curr.key.equals(key)) {
                break;
            }
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public void set(K key, V newValue) { // O(1)
        int index = hash(key, data.length);
        Node<K, V> node = getNode(key, index);
        if (node != null) {
            node.value = newValue;
        } else {
            throw new NoSuchElementException("没有对应的 key ：" + key);
        }
    }

    @Override
    public V get(K key) { // O(1)
        int index = hash(key, data.length);
        Node<K, V> node = getNode(key, index);
        return node == null ? null : node.value;
    }

    @Override
    public boolean containsKey(K key) { // O(1)
        int index = hash(key, data.length);
        Node<K, V> node = getNode(key, index);
        return node != null;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.add1(2,1);
        map.add1(1,2);
        map.add1(9,3);
        map.add1(5,4);
        map.add1(2,5);
        System.out.println();
    }
}
