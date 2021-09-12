package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ThreeWayQuickSorterArrayList extends Sorter {
    public void sort(ArrayList<Integer> data) {
        if (data == null || data.size() <= 1) return;
        Integer[] dataArr = data.toArray(new Integer[data.size()]);
        sort(dataArr, 0, dataArr.length - 1);
        data.clear(); // 清空
        for (Integer val : dataArr) data.add(val);
    }

    private void sort(Integer[] data, int lo, int hi) {
        if (lo >= hi) return;
        // 分区
        Integer pivot = data[hi];
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

    public void sort(ArrayList<Integer> data, Comparator<Integer> c) {
        if (data == null || data.size() <= 1) return;
        Integer[] dataArray = data.toArray(new Integer[data.size()]);
        sort(dataArray, 0, dataArray.length - 1, c);
        data.clear(); // 清空
        for (Integer val : dataArray) data.add(val);
    }

    private void sort(Integer[] data, int lo, int hi, Comparator<Integer> c) {
        if (lo >= hi) return;
        // 分区
        Integer pivot = data[hi];
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
}
