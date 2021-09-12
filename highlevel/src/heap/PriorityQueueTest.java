package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        // Java 内置优先队列，默认使用小顶堆实现的
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        maxHeap.add(13);
        maxHeap.add(10);
        maxHeap.add(56);

        System.out.println(maxHeap.remove());
        System.out.println(maxHeap.remove());
    }
}
