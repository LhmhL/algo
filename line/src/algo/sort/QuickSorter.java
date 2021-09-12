package algo.sort;

import java.util.Arrays;

public class QuickSorter extends Sorter {
    // 时间复杂度：O(nlogn)，最差O(n^2)
    // 空间复杂度：O(logn) 递归系统调用栈导致的
    // 不稳定
    // 重点是分区
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        sort(data, 0, data.length - 1); // 大问题
    }

    // 子问题
    private void sort(int[] data, int lo, int hi) {
        // 终止递归条件
        if (lo >= hi) return;
        // 分区
        int j = partition(data, lo, hi);
        // 对左边数组排序
        sort(data, lo, j - 1); // log2n
        // 对右边数组排序
        sort(data, j + 1, hi); // log2n
    }

    // 二向切分
    // [lo,less) <pivot
    // [less,great) >pivot
    // [great,hi) 未处理 hi为pivot
    // 分区
    private int partition(int[] data, int lo, int hi) {
        int pivot = data[hi];
        int less = lo;
        int great = lo;
        for (; great < hi; great++) {
            if (data[great] < pivot) {
                swap(data, less, great); // 不稳定
                less++;
            }
        }
        swap(data, less, hi);
        return less;
    }

    // 二向切分
    // [lo,less) <pivot
    // [less,great) >=pivot
    // [great,hi) 未处理 hi为pivot不用处理
    // 分区
    private int partition1(int[] data, int lo, int hi) {
        int pivot = data[hi];
        int less = lo;
        int great = lo;
        while (great < hi) {
            if (data[great] < pivot) {
                swap(data, less, great); // 不稳定
                less++;
            }
            great++;
        }
        swap(data, less, hi);
        return less;
    }

    public static void main(String[] args) {
        int[] data = new int[]{34, 33, 12, 78, 21, 1, 98, 100};
        new QuickSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
