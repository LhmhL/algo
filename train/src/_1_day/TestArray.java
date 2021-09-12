package _1_day;

import java.util.HashMap;
import java.util.Map;

public class TestArray {
    /**
     * 计算输入数组中每个元素出现的次数
     * @param arr
     * @return
     */
    private static Map<Integer, Integer> countArray1(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                countMap.put(num, count + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        return countMap;
    }

    /**
     * 计算输入数组中每个元素出现的次数
     * @param arr
     * @return
     */
    private static int[] countArray2(int[] arr) {
        int[] count = new int[6];
        for (int num : arr) {
            // 元素值作为索引下标
            int index = num - 1;
            count[index]++;
        }
        return count;
    }
}
