package heap;

import java.util.Arrays;

public class HeapSort {
    // 时间复杂度：O(nlogn)
    // 空间复杂度：O(n) O(1)
    public void sort(Integer[] data) {
        // 1. 建堆，堆化
        MaxHeap<Integer> maxHeap = new MaxHeap<>(data);

        // 2. 排序
//        Integer[] tmp = new Integer[data.length];
        int i = 0;
        // 时间复杂度：O(nlogn)
        while (!maxHeap.isEmpty()) { // O(n)
//            tmp[i] = maxHeap.removeMax(); // O(logn)
            data[i] = maxHeap.removeMax(); // O(logn)
            i++;
        }

        // 3. 拷贝
//        for (int j = 0; j < data.length; j++) {
//            data[j] = tmp[j];
//        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{15, 17, 19, 13, 22, 16, 28, 30, 42, 66};
        new HeapSort().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
