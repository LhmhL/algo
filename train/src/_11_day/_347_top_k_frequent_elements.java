package _11_day;

import java.util.*;

public class _347_top_k_frequent_elements {
    /* leetcode 347 号算法题：前 K 个高频元素

    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
    你可以按 任意顺序 返回答案。

    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [2, 1]

    输入: nums = [1], k = 1
    输出: [1]

    1 <= nums.length <= 10^5
    k 的取值范围是 [1, 数组中不相同的元素的个数]
    题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的

    进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     */

    // 小顶堆
    // 时间复杂度：O(nlogk)
    // 空间复杂度：O(n)
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq
                = new PriorityQueue<>(k + 1, (a, b) -> count.get(a) - count.get(b));

        for (int num : count.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.remove();
        }

        // 小顶堆中存储的就是出现了前 k 个高频的元素
        int[] res = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            res[index++] = pq.remove();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] res = new _347_top_k_frequent_elements().topKFrequent1(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    private Random random = new Random(System.currentTimeMillis());
    private Map<Integer, Integer> count;

    // 快速排序分区优化
    // 时间复杂度：
    // 空间复杂度：
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        int[] uniqueNums = new int[count.size()];
        int index = 0;
        for (int num : count.keySet()) uniqueNums[index++] = num;

        int left = 0, right = uniqueNums.length - 1;
        int target = uniqueNums.length - k;
        while (true) {
            int pivotIndex = partition(uniqueNums, left, right);
            if (pivotIndex == target) {
                break;
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return Arrays.copyOfRange(uniqueNums, uniqueNums.length - k, uniqueNums.length);
    }

    private int partition(int[] nums, int left, int right) {
        if (right > left) {
            int pivotIndex = left + 1 + random.nextInt(right - left);
            swap(nums, pivotIndex, right);
        }
        int pivot = count.get(nums[right]);
        int less = left, great = left;
        for (; great < right; great++) {
            if (count.get(nums[great]) < pivot) {
                swap(nums, less, great);
                less++;
            }
        }
        swap(nums, less, right);
        return less;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
