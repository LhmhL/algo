package set;

public class ArrayListSet<E> implements Set<E> {
    private ArrayList<E> data;

    public ArrayListSet() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E e) { // O(n)
        if (!data.contains(e)) {
            data.addLast(e);
        }
    }

    @Override
    public void remove(E e) { // O(n)
        data.removeElement(e);
    }

    @Override
    public boolean contains(E e) { // O(n)
        return data.contains(e);
    }

    @Override
    public String toString() {
        return "ArraySet{" +
                "data=" + data.toString() +
                '}';
    }

    public static void main(String[] args) {
        Set<Integer> set = new ArrayListSet<>();
        set.add(2);
        set.add(4);
        set.add(1);

        System.out.println(set);

        set.add(2);
        System.out.println(set);

        System.out.println(set.contains(4));

        set.remove(1);
        System.out.println(set);
    }
}
