package set;

import java.util.List;

/*
    有序的 Set
 */
public class BSTreeSet<E extends Comparable<E>> implements Set<E> {
    private BSTree<E> bst;

    public BSTreeSet() {
        this.bst = new BSTree<>();
    }

    @Override
    public int size() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) { // O(logn)
        bst.add(e);
    }

    @Override
    public void remove(E e) { // O(logn)
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) { // O(logn)
        return bst.contains(e);
    }

    public List<E> getAllElements() {
        return bst.inOrder();
    }

    public static void main(String[] args) {
        BSTreeSet<Integer> set = new BSTreeSet<>();
        set.add(2);
        set.add(1);
        set.add(9);
        set.add(5);
        set.add(2);
        System.out.println(set.getAllElements());
    }
}
