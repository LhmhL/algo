package algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSorter {
    // 时间复杂度：O(nlog(n/m)) O(n) m表示桶的个数
    // 空间复杂度：O(m)
    // 稳不稳定取决于对桶内元素排序的算法
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 创建几个空的 bucket
        int maxValue = data[0];
        for (int d : data) {
            maxValue = Math.max(maxValue, d);
        }
        int bucketNum = maxValue / 10 + 1; // 39 / 10 + 1 = 4
        ArrayList<Integer>[] buckets = new ArrayList[bucketNum];

        // 2. 将所有的元素添加进对应的 bucket
        for (int i = 0; i < data.length; i++) {
            // 计算当前元素应该被分配到哪一个桶
            int index = data[i] / 10;
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(data[i]);
        }

        // 3. 对每一个 bucket 中的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            ArrayList<Integer> bucketData = buckets[i];
            if (bucketData != null) {
                // 第一种方法
//                Collections.sort(bucketData);
                // 第二种方法
//                Integer[] bucketDataArr = bucketData.toArray(new Integer[bucketData.size()]);
//                Arrays.sort(bucketDataArr);
                // 第三种方法
//                Integer[] bucketDataArr = bucketData.toArray(new Integer[bucketData.size()]);
//                new ThreeWayQuickSorterE<Integer>().sort(bucketDataArr);
//                bucketData.clear(); // 清空
//                for (Integer val : bucketDataArr) bucketData.add(val);
                // 第四种方法
                new ThreeWayQuickSorterArrayList().sort(bucketData);
            }
        }

        // 4. 从 buckets 中拿到排序后的数组
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            ArrayList<Integer> bucketData = buckets[i];
            if (bucketData != null) {
                for (int j = 0; j < bucketData.size(); j++) {
                    data[index++] = bucketData.get(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{2, 5, 1, 23, 22, 33, 56, 12, 5, 3, 5, 6, 8, 2, 3, 4};
        new BucketSorter().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
