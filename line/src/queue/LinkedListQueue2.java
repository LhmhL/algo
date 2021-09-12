package queue;

public class LinkedListQueue2<E> implements Queue<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
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
            return e.toString();
        }
    }

    private Node head;
    private Node tail;

    private int size;

    public LinkedListQueue2() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) { // O(1)
        Node newNode = new Node(e);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() { // O(1)
        if (isEmpty()) {
            throw new RuntimeException("dequeue error, no element");
        }
        Node delNode = head;
        head = head.next;
        delNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("getFront error, no element");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue：队首 [");
        Node curr = head;
        while (curr != null) {
            res.append(curr.e + "=>");
            curr = curr.next;
        }
        res.append("null]");
        return res.toString();
    }
}
