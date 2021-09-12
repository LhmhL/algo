package set;

import java.util.Arrays;

// 解决哈希冲突：开放寻址法
public class HashSet2<E> implements Set<E> {
    private class Item<E> {
        E e;
        boolean isDeleted;

        public Item(E data) {
            this.e = data;
            this.isDeleted = false;
        }

        @Override
        public int hashCode() {
            return e.hashCode();
        }

        @Override
        public String toString() {
            return "Item{" +
                    "e=" + e +
                    ", isDeleted=" + isDeleted +
                    '}';
        }
    }

    private Item<E>[] data;
    private int size;
    private int deleteCount; // 用于记录有多少标记删除的元素
    private double loadFactor = 0.75; // 装载因子

    public HashSet2(int capacity) {
        data = new Item[capacity];
        this.size = 0;
        this.deleteCount = 0;
    }

    public HashSet2() {
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
        Item<E>[] newData = new Item[newCapacity];
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && !data[i].isDeleted) {
                int newIndex = hash(data[i].e, newCapacity);
                newData[newIndex] = data[i];
            }
        }
        // 所有标记为删除的元素都清理掉了
        deleteCount = 0;
        data = newData;
    }

    @Override
    public void add(E e) { // 最好：O(1)，最坏：O(n)
        int index = hash(e, data.length);
        // addIndex 表示元素 e 需要插入的索引位置
        int addIndex = index;
        // isFirst 用于辅助找到元素 e 插入的位置
        boolean isFirst = true;
        // add 前先判断是否存在元素 e
        while (data[index] != null && !e.equals(data[index].e)) {
            // 找到第一个等于 null 或者删除的元素，并记录赋值给 addIndex
            if ((data[index] == null || data[index].isDeleted) && isFirst) {
                addIndex = index;
                isFirst = false;
            }
            index++;
            index = index % data.length;
        }
        // 说明已经存在 e，则直接返回
        if (data[index] != null && !data[index].isDeleted) return;
        // 这个时候的 addIndex 对应的元素要么是 null ，要么是已经删除的元素
        // 如果 addIndex 对应的元素是标记为删除的元素，那么直接被覆盖了，标记为删除的元素个数减 1
        if (data[addIndex] != null && data[addIndex].isDeleted) {
            deleteCount--;
        }
        data[addIndex] = new Item(e);
        size++;
        if (size >= data.length * loadFactor) {
            resize(2 * data.length);
        }
    }

    @Override
    public void remove(E e) { // 最好：O(1)，最坏：O(n)
        int index = hash(e, data.length);
        // 找到等于 e 或者元素为 null 的索引
        while (data[index] != null && !e.equals(data[index].e)) {
            index++;
            index = index % data.length;
        }
        if (data[index] != null) {
            data[index].isDeleted = true;
            size--;
            deleteCount++;
        }
        // 如果标记为删除的元素太多的话，我们进行 resize，清除标记为删除的元素
        // 这里可能会产生时间复杂度震荡
        if (deleteCount + size >= data.length * loadFactor) {
            resize(data.length);
        }
    }

    @Override
    public boolean contains(E e) { // 最好：O(1)，最坏：O(n)
        int index = hash(e, data.length);
        // 找到等于 e 或者元素为 null 的索引
        while (data[index] != null && !e.equals(data[index].e)) {
            index++;
            index = index % data.length;
        }
        return data[index] != null && !data[index].isDeleted;
    }

    @Override
    public String toString() {
        return "HashSet2{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                ", deleteCount=" + deleteCount +
                ", loadFactor=" + loadFactor +
                '}';
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet2<>();
        set.add(0);
        set.add(1);
        set.remove(0);
        set.remove(1);
        set.add(2);
        set.add(3);
        set.remove(2);
        set.remove(3);
        set.add(4);
        set.add(5);
        set.remove(4);
        set.remove(5);
        set.add(10);
        set.add(11);
        set.add(20);
        set.add(21);
        System.out.println(set);
    }
}
