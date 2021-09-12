package algo.sort;

import java.util.ArrayList;
import java.util.Comparator;

public class ThreeWayQuickSorterArrayListE<E extends Comparable<E>> extends Sorter {
    public void sort(ArrayList<E> data) {
        if (data == null || data.size() <= 1) return;
        // 类型转换异常，泛型的特点，这样做无意义
        E[] dataArr = data.toArray((E[])new Object[data.size()]);
//        E[] dataArr = (E[])data.toArray();
        sort(dataArr, 0, dataArr.length - 1);
        data.clear(); // 清空
        for (E val : dataArr) data.add(val);
    }

    private void sort(E[] data, int lo, int hi) {
        if (lo >= hi) return;
        // 分区
        E pivot = data[hi];
        int less = lo;
        int great = hi;
        int i = lo;
        while (i <= great) {
            if (data[i].compareTo(pivot) < 0) {
                swap(data, i, less);
                less++;
                i++;
            } else if (data[i].compareTo(pivot) > 0) {
                swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }
        sort(data, lo, less - 1);
        sort(data, great +1, hi);
    }

    public void sort(ArrayList<E> data, Comparator<E> c) {
        if (data == null || data.size() <= 1) return;
        // 类型转换异常，泛型的特点，这样做无意义
        E[] dataArray = data.toArray((E[])new Object[data.size()]);
//        E[] dataArr = (E[])data.toArray();
        sort(dataArray, 0, dataArray.length - 1, c);
        data.clear(); // 清空
        for (E val : dataArray) data.add(val);
    }

    private void sort(E[] data, int lo, int hi, Comparator<E> c) {
        if (lo >= hi) return;
        // 分区
        E pivot = data[hi];
        int less = lo;
        int great = hi;
        int i = lo;
        while (i <= great) {
            if (c.compare(data[i], pivot) < 0) {
                swap(data, i, less);
                less++;
                i++;
            } else if (c.compare(data[i], pivot) > 0) {
                swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }
        sort(data, lo, less - 1, c);
        sort(data, great +1, hi, c);
    }

    public static void main(String[] args) {
        Person p1 = new Person("douma", 40);
        Person p2 = new Person("laotang", 30);
        Person p3 = new Person("douma1", 32);
        Person p4 = new Person("laotang2", 33);
        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        new ThreeWayQuickSorterArrayListE<Person>().sort(list); // Person类实现了Comparable接口
        System.out.println(list);

        Comparator<Person> comparator = ((o1, o2) -> o1.getAge() - o2.getAge());
        new ThreeWayQuickSorterArrayListE<Person>().sort(list, comparator); // Comparator比较器
        System.out.println(list);
    }
}
