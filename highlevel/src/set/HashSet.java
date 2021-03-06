package set;

public class HashSet<E> implements Set<E> {
    private E[] data;
    private int size;

    public HashSet(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public HashSet() {
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
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                int newIndex = hash(data[i], newCapacity);
                newData[newIndex] = data[i];
            }
        }
        data = newData;
    }

    @Override
    public void add(E e) { // O(1)
        int index = hash(e, data.length);
        if (data[index] != null) {
            data[index] = e;
            size++;
            if (size == data.length) {
                resize(2 * data.length);
            }
        }
    }

    @Override
    public void remove(E e) { // O(1)
        int index = hash(e, data.length);
        if (data[index] != null) {
            data[index] = null;
            size--;
        }
    }

    @Override
    public boolean contains(E e) { // O(1)
        int index = hash(e, data.length);
        return data[index] != null;
    }
}
