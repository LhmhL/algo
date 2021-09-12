package stack;

import linkedlist.DoubleLinkedList;
import linkedlist.SingleLinkedList;

public class LinkedListStack<E> implements Stack<E> {
//    private DoubleLinkedList<E> linkedList;
    private SingleLinkedList<E> linkedList;

    public LinkedListStack() {
//        linkedList = new DoubleLinkedList<>();
        linkedList = new SingleLinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        res.append("Stack：[");
//        for (int i = linkedList.getSize() - 1; i >= 0; i--) {
//            res.append(linkedList.get(i));
//            if (i != 0) {
//                res.append(", ");
//            }
//        }
//        res.append("] top");
        res.append("Stack：top [");
        for (int i = 0; i < linkedList.getSize(); i++) {
            res.append(linkedList.get(i));
            if (i != linkedList.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
