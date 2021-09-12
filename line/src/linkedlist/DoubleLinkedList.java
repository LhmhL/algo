package linkedlist;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {
    private class Node {
        E e;
        Node prev;
        Node next;

        public Node(Node prev, E e, Node next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public Node(E e) {
            this(null, e, null);
        }

        public Node() {
            this(null,null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head; // 头节点
    private Node tail; // 尾节点

    private int size;

    public DoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 查询指定索引的节点值
     * @param index
     * @return
     */
    // 时间复杂度是 O(n)
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index failed, index must >= 0 and < size");
        Node node = node(index);
        return node.e;
    }

    public E getFirst() {
        return head.e;
    }

    public E getLast() {
        return tail.e;
    }

    // 时间复杂度是 O(n)
    private Node node(int index) {
        if (index < 0 || index >= size)
            return null;

        Node curr = null;
        // 如果 index 小于链表长度的一半，则从 head 开始遍历查找
        if (index < size / 2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else { // 如果 index 大于等于链表长度的一半，则从 tail 开始遍历查找
            curr = tail;
            for (int i = 0; i < size - index - 1; i++) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    /**
     * 修改指定索引的节点值
     * @param index
     * @param e
     */
    // 时间复杂度是 O(n)
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index failed, index must >= 0 and < size");
        Node node = node(index);
        node.e = e;
    }

    /**
     * 往链表表头插入节点
     * @param e
     */
    public void addFirst(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            // 如果头节点为空，说明链表中没有一个节点
            // 那么新插入的节点既是头节点，又是尾节点
            tail = newNode;
        } else {
            // 将新节点作为头节点
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    /**
     * 往链表表尾插入节点
     * @param e
     */
    public void addLast(E e) {
        Node newNode = new Node(e);
        if (tail == null) {
            // 如果尾节点为空，说明链表中没有一个节点
            // 那么新插入的节点既是头节点，又是尾节点
            head = newNode;
        } else {
            // 将新节点作为尾节点
            newNode.prev = tail;
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    /**
     * 往指定索引位置插入节点
     * @param index
     * @param e
     */
    // 时间复杂度是 O(n)
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, index must >= 0 and <= size");

        if (index == size) {
            addLast(e);
        } else if (index == 0) {
            addFirst(e);
        } else {
            // 1. 找到要插入的位置，并记住这个位置的节点
            Node next = node(index);
            Node prev = next.prev;

            // 2. 新建节点，将它的 next 指向 next，将它的 prev 指向 prev
            Node newNode = new Node(prev, e, next);

            // 3. 将新建节点设置为 next 的 prev
            next.prev = newNode;

            // 4. 将新建节点设置为 prev 的 next
            prev.next = newNode;

            size++;
        }
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E e = head.e;
        // 拿到头节点的下一个节点
        Node next = head.next;
        // 如果 next 为空，说明整个链表只有一个节点
        if (next == null) {
            head = null;
            tail = null;
        } else {
            // 将头节点从链表中断开
            head.next = null;
            next.prev = null;
            // 将 next 设置为头节点
            head = next;
        }
        size--;
        return e;
    }

    public E removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        E e = tail.e;
        // 拿到尾节点的前一个节点
        Node prev = tail.prev;
        // 如果 prev 为空，说明整个链表只有一个节点
        if (prev == null) {
            tail = null;
            head = null;
        } else {
            // 将尾节点从链表中断开
            tail.prev = null;
            prev.next = null;
            // 将 prev 设置为尾节点
            tail = prev;
        }
        size--;
        return e;
    }

    // 时间复杂度是 O(n)
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index failed, index must >= 0 and < size");

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        }

        // 1. 找到要删除的节点
        Node delNode = node(index);
        E e = delNode.e;

        // 2. 记住要删除节点的 prev 和 next 节点
        Node prev = delNode.prev;
        Node next = delNode.next;

        // 3. 将删除节点的前后节点联系起来
        prev.next = next;
        next.prev = prev;

        // 4. 将删除节点从链表中断开
        delNode.next = null;
        delNode.prev = null;

        size--;
        return e;
    }

    /**
     * 删除指定值的节点
     * @param e
     */
    public void removeElement(E e) {
        if (head == null)
            throw new IllegalArgumentException("removeElement failed, LinkedList is Empty");

        Node prev = head.prev;
        Node curr = head;
        Node next = head.next;
        while (curr != null) {
            if (curr.e.equals(e)) {
                break;
            }
            prev = curr;
            curr = next;
            next = next.next;
        }

        prev.next = curr.next;
        next.prev = curr.prev;

        curr.prev = null;
        curr.next = null;

        size--;
    }

    /**
     * 判断链表中是否存在指定元素
     * @param e
     * @return
     */
    // 时间复杂度： O(n)
    public boolean contains(E e) {
        Node curr = head;
        while (curr != null) {
            if (curr.e.equals(e)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.e + "=>");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
