package heap.train;

import java.util.PriorityQueue;
import java.util.Random;

public class _215_KthLargestElementInAnArray {
    // 优先队列
    // 时间复杂度：O(Max(k * logk, (n - k) * logk))
    // 空间复杂度：O(min(k, n - k))
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k < len - k) {
            // 小顶堆放大数
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
            // O(k * logk)
            for (int i = 0; i < k; i++) { // O(k)
                minHeap.add(nums[i]); // O(logk)
            }
            // O((n - k) * logk)
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > minHeap.peek()) {
                    minHeap.remove(); // O(logk)
                    minHeap.add(nums[i]); // O(logk)
                }
            }
            return minHeap.peek();
        } else {
            int capacity = len - k + 1;
            // 大顶堆放小数
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(capacity, (a, b) -> b - a);
            // O(k * logk)
            for (int i = 0; i < capacity; i++) { // O(k)
                maxHeap.add(nums[i]); // O(logk)
            }
            // O((n - k) * logk)
            for (int i = capacity; i < nums.length; i++) {
                if (nums[i] < maxHeap.peek()) {
                    maxHeap.remove(); // O(logk)
                    maxHeap.add(nums[i]); // O(logk)
                }
            }
            return maxHeap.peek();
        }
    }

    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private Random random = new Random(System.currentTimeMillis());
    private int partition(int[] data, int lo, int hi) {
        if (hi > lo) {
            int randomIndex = lo + 1 + random.nextInt(hi - lo);
            swap(data, hi, randomIndex);
        }
        int pivot = data[hi];
        int less = lo;
        int great = lo;
        for (; great <= hi - 1; great++) {
            if (data[great] < pivot) {
                swap(data, less, great);
                less++;
            }
        }
        swap(data, less, hi);
        return less;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
