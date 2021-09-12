package heap;

import java.util.Random;

public class HeapifyTest {
    private static double testHeapify(Integer[] arr, boolean isSiftDown) {
        long startTime = System.nanoTime();
        if (isSiftDown) {
            MaxHeap<Integer> heap = new MaxHeap<>(arr); //O(n)
        } else {
            MaxHeap<Integer> heap = new MaxHeap<>();
            //O(nlogn)
            for (int i = 0; i < arr.length; i++) {  //O(n)
                heap.add(arr[i]);  //O(logn)
            }
        }
        return (System.nanoTime() - startTime) / 1000_000_000.0;
    }

    public static void main(String[] args) {
        int cnt = 10000000;
        Random random = new Random();
        Integer[] arr = new Integer[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = random.nextInt();
        }

        double time1 = testHeapify(arr, false);
        System.out.println("使用 sift up 花费的时间：" + time1);

        double time2 = testHeapify(arr, true);
        System.out.println("使用 sift down 花费的时间：" + time2);
    }
}
