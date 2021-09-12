package queue;

import linkedlist.DoubleLinkedList;
import linkedlist.SingleLinkedList;

public class LinkedListQueue<E> implements Queue<E> {
//    private DoubleLinkedList<E> data;
    private SingleLinkedList<E> data;

    public LinkedListQueue() {
//        data = new DoubleLinkedList<>();
        data = new SingleLinkedList<>();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e); // 单向O(n)，双向O(1)
    }

    @Override
    public E dequeue() {
        return data.removeFirst(); // O(1)
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue：队首 [");
        for (int i = 0; i < data.getSize(); i++) {
            res.append(data.get(i));
            if (i != data.getSize() - 1) {
                res.append("=>");
            }
        }
        res.append("]");
        return res.toString();
    }
}
