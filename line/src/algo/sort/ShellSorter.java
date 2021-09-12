package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSorter extends Sorter {
    // 时间复杂度：O(n^(3/2))
    // 空间复杂度：O(1)
    // 不稳定
    // 希尔排序性能比插入排序好，不交换元素的希尔排序性能比交换元素的好。
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 计算递增序列
        int n = data.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121......

        // 2. 希尔排序
        while (h >= 1) {
            // 将数组变为 h 有序
            for (int i = h; i < n; i++) {
                int tmp = data[i];
                int j = i;
                for (; j >= h; j = j - h) {
                    if (tmp < data[j - h]) { // 不稳定
                        data[j] = data[j - h];
                    } else {
                        break;
                    }
                }
                data[j] = tmp;
            }
            h = h / 3;
        }
    }

    public void sort3(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 计算递增序列
        int n = data.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121......

        // 2. 希尔排序
        while (h >= 1) {
            // 将数组变为 h 有序
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (data[j] < data[j - h]) {
                        swap(data, j , j - h); // 不稳定
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }

    public void sort2(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 计算递增序列
        int n = data.length;
        ArrayList<Integer> list = new ArrayList<>();
        int k = 1;
        int h = 1;
        do {
            list.add(h); // 1, 4, 13, 40, 121......
            k++;
            h = ((int)Math.pow(3, k) - 1) / 2;
            if (h > n / 3) break;
        } while (h <= n / 3);

        // 2. 希尔排序
        for (k = list.size() - 1; k >= 0 ; k--) { // 倒序遍历
            h = list.get(k);
            // 将数组变为 h 有序
            for (int i = h; i < n; i++) {
                int tmp = data[i];
                int j = i;
                for (; j >= h; j = j - h) {
                    if (tmp < data[j - h]) { // 不稳定
                        data[j] = data[j - h];
                    } else {
                        break;
                    }
                }
                data[j] = tmp;
            }
        }
    }

    public void sort1(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 计算递增序列
        int n = data.length;
        ArrayList<Integer> list = new ArrayList<>();
        int k = 1;
        int h = 1;
        do {
            list.add(h); // 1, 4, 13, 40, 121......
            k++;
            h = ((int)Math.pow(3, k) - 1) / 2;
            if (h > n / 3) break;
        } while (h <= n / 3);

        // 2. 希尔排序
        for (k = list.size() - 1; k >= 0 ; k--) { // 倒序遍历
            h = list.get(k);
            // 将数组变为 h 有序
            for (int i = h; i < data.length; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (data[j] < data[j - h]) {
                        swap(data, j , j - h); // 不稳定
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 1, 23, 22, 33, 56, 12, 5, 3, 5, 6, 8, 2, 3, 4};
        new ShellSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
