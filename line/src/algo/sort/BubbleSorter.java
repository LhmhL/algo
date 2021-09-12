package algo.sort;

import java.util.Arrays;

public class BubbleSorter extends Sorter {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    // 稳定
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        for (int i = 0; i < data.length; i++) { // 控制冒泡轮数
            boolean hasSwap = false;
            for (int j = 0; j < data.length - i - 1; j++) { // 控制每轮比较次数
                if (data[j] > data[j + 1]) { // 稳定
                    swap(data, j, j + 1);
                    hasSwap = true;
                }
            }
            if (!hasSwap) break;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{12, 23, 36, 9, 24, 42};
        new BubbleSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
