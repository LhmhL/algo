package algo.sort;

import java.util.Arrays;

public class SelectionSorter extends Sorter {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    // 不稳定
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        for (int i = 0; i < data.length; i++) { // 控制选择轮数
            // 找到 [i, n) 中的最小元素所在的索引
            int minNumIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minNumIndex]) {
                    minNumIndex = j;
                }
            }
            // 将 data[i] 和最小元素进行交换
            if (minNumIndex != i) {
                swap(data, i, minNumIndex); // 不稳定
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 23, 36, 9, 24, 42};
        new SelectionSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
