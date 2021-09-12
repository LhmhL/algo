package queue;

import arraylist.ArrayList;

public class ArrayListQueue<E> implements Queue<E> {
    private ArrayList<E> data;

    public ArrayListQueue(int capacity) {
        this.data = new ArrayList<>(capacity);
    }

    public ArrayListQueue() {
        this(10);
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
    public void enqueue(E e) { // O(1)
        data.addLast(e);
    }

    @Override
    public E dequeue() { // O(n)
        return data.removeFirst();
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
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
