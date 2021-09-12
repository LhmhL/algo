package algo.sort;

import java.util.Arrays;

public class RadixSorter {
    // 时间复杂度：O(Cn) O(n) C表示数组最大值的位数
    // 空间复杂度：O(n)
    // 稳定，因为计数排序是稳定的
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 找到最大值
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            max = Math.max(max, data[i]);
        }

        // 2. 对数组按照每个元素的每位进行计数排序
        for (int exp = 1; max / exp > 0; exp *= 10) { // O(Cn)
            countSort(data, exp); // O(n)
        }
    }

    private void countSort(int[] data, int exp) { // O(n)
        // 之所以是 10，是因为数字只有 0...9 十个数字
        int[] count = new int[10];

        for (int i = 0; i < data.length; i++) {
            // 个位数： (234 / 1) % 10 = 4
            // 十位数： (234 / 10) % 10 = 3
            // 百位数： (234 / 100) % 10 = 2
            int digit = (data[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[data.length];
        for (int i = data.length - 1; i >= 0; i--) { // 稳定
            int digit = (data[i] / exp) % 10;
            int k = count[digit] - 1;
            output[k] = data[i];
            count[digit]--;
        }

        for (int i = 0; i < data.length; i++)
            data[i] = output[i];
    }

    public static void main(String[] args) {
        int[] data = new int[]{4512, 4231, 31923, 2165, 1141};
        new RadixSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
