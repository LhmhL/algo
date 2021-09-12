package algo.sort;

import java.util.Arrays;

public class InsertionSorter extends Sorter {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    // 稳定
    // 插入排序性能最好，其次是选择排序，最后是冒泡排序。不交换元素的插入排序性能比交换元素的好。
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        // 插入排序的轮数
        for (int i = 0; i < data.length; i++) {
            int tmp = data[i];
            int j = i;
            for (; j > 0; j--) {
                if (tmp < data[j - 1]) { // 稳定
                    // 将较大的元素总是向右移动
                    data[j] = data[j - 1];
                } else {
                    break;
                }
            }
            // 找到 i 对应的元素需要插入的位置
            data[j] = tmp;
        }
    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public void sort3(int[] data) {
        if (data == null || data.length <= 1) return;
        // 插入排序的轮数
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j = i;
            while (j > 0 && tmp < data[j - 1]) { // 稳定
                data[j] = data[j - 1];
                j--;
            }
            data[j] = tmp;
        }
    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public void sort2(int[] data) {
        if (data == null || data.length <= 1) return;
        // 插入排序的轮数
        for (int i = 1; i < data.length; i++) {
            int j = i;
            while (j > 0 && data[j] < data[j - 1]) {  // 稳定
                swap(data, j , j - 1);
                j--;
            }
        }
    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public void sort1(int[] data) {
        if (data == null || data.length <= 1) return;
        // 插入排序的轮数
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j > 0; j--) {
                if (data[j] < data[j - 1]) { // 稳定
                    swap(data, j , j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 23, 36, 9, 24, 42};
        new InsertionSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
