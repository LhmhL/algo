package queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int head;
    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity];
        head = tail =0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    // 当前队列的容量
    private int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) { // O(1)
        if ((tail + 1) % data.length == head) {
            // 队列满了
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() { // O(1)
        if (isEmpty()) {
            throw new RuntimeException("dequeue error, No Element for dequeue");
        }
        E res = data[head];
        data[head] = null;
        size--;
        head = (head + 1) % data.length;
        if (size == getCapacity() / 2 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + head) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        return data[head];
    }

    @Override
    public boolean isEmpty() {
//        return size == 0;
        return head == tail;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue：size = %d, capacity = %d\n", size, getCapacity()));
        sb.append(" 队首 [");
        for (int i = head; i != tail ; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
