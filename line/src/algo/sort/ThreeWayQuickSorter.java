package algo.sort;

import java.util.Arrays;

public class ThreeWayQuickSorter extends Sorter {
    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(logn) 递归系统调用栈导致的
    // 不稳定
    // 重点是分区
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        sort(data, 0, data.length - 1);
    }

    // 三向切分
    // [lo,less) <pivot
    // [less,i) =pivot
    // [i,great] 未处理
    // (great,hi] >pivot
    // 分区
    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        // 分区
        int pivot = data[hi];
        int less = lo;
        int great = hi;
        int i = lo;
        while (i <= great) {
            if (data[i] < pivot) {
                swap(data, i, less); // 不稳定
                less++;
                i++;
            } else if (data[i] > pivot) {
                swap(data, i, great); // 不稳定
                great--;
            } else {
                i++;
            }
        }
        sort(data, lo, less - 1);
        sort(data, great + 1, hi);
    }

    public static void main(String[] args) {
        int[] data = new int[]{34, 33, 12, 78, 21, 1, 98, 100};
        new ThreeWayQuickSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
