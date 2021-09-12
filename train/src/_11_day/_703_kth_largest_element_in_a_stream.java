package _11_day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _703_kth_largest_element_in_a_stream {
    /*  leetcode 703 号算法题：数据流中的第 K 大元素
    设计一个找到数据流中第 k 大元素的类（class）。
    注意是排序后的第 k 大元素，不是第 k 个不同的元素。

    请实现 KthLargest 类：
        1. KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
        2. int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。

    输入：
        ["KthLargest", "add", "add", "add", "add", "add"]
        [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   输出：
        [null, 4, 5, 5, 8, 8]

   解释：
        KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

    1 <= k <= 10^4
    0 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    -10^4 <= val <= 10^4
    最多调用 add 方法 10^4 次
    题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
     */
}

// 1. 普通排序
class KthLargest1 {
    private List<Integer> data;
    private int k;

    // 时间复杂度：O(n)
    public KthLargest1(int k, int[] nums) {
        data = new ArrayList<>();
        this.k = k;
        for (int num : nums) data.add(num);
    }

    // 时间复杂度：O(nlogn)
    public int add(int val) {
        data.add(val);
        Collections.sort(data);
        if (data.size() < k) {
            return data.get(0);
        } else {
            return data.get(data.size() - k);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        KthLargest1 kl = new KthLargest1(3, nums);
        System.out.println(kl.add(6));
        System.out.println(kl.add(7));
        System.out.println(kl.add(8));
    }
}

// 2. 插入排序
class KthLargest2 {
    private List<Integer> data;
    private int k;

    // 时间复杂度：O(nlogn)
    public KthLargest2(int k, int[] nums) {
        this.data = new ArrayList<>();
        this.k = k;
        for (int num : nums) data.add(num);
        Collections.sort(data);
    }

    // 时间复杂度：O(n)
    public int add(int val) {
        if (data.isEmpty()) {
            data.add(val);
        } else {
            // 插入排序
            int n = data.size();
            data.add(Integer.MIN_VALUE);
            int j = n;
            for (; j > 0; j--) {
                if (val < data.get(j - 1)) {
                    data.set(j, data.get(j - 1));
                } else {
                    break;
                }
            }
            data.set(j, val);
        }
        return data.get(data.size() - k);
    }
}

// 3. 小顶堆
class KthLargest {
    private PriorityQueue<Integer> data;
    private int k;

    // 时间复杂度：O(nlogk)
    public KthLargest(int k, int[] nums) {
        data = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            if (data.size() < k) {
                data.add(num);
            } else if (num > data.peek()) {
                data.remove();
                data.add(num);
            }
        }
    }

    // 时间复杂度：O(logk)
    public int add(int val) {
        if (data.size() < k) {
            data.add(val);
        } else if (val > data.peek()) {
            data.remove();
            data.add(val);
        }
        return data.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        KthLargest kl = new KthLargest(3, nums);
        System.out.println(kl.add(6));
        System.out.println(kl.add(7));
        System.out.println(kl.add(8));
    }
}

class KthLargest3 {
    private List<Integer> data;
    private int k;

    // 时间复杂度：O(n)
    public KthLargest3(int k) {
        data = new ArrayList<>();
        this.k = k;
    }

    // 时间复杂度：O(nlogn)
    public int add(int val) {
        data.add(val);
        Collections.sort(data);
        if (data.size() < k) {
            return data.get(0);
        } else {
            return data.get(data.size() - k);
        }
    }

    public static void main(String[] args) {
        KthLargest3 kl = new KthLargest3(3);
        System.out.println(kl.add(5));
        System.out.println(kl.add(6));
        System.out.println(kl.add(7));
        System.out.println(kl.add(8));
    }
}

class KthLargest4 {
    private PriorityQueue<Integer> data;
    private int k;

    // 时间复杂度：
    public KthLargest4(int k) {
        data = new PriorityQueue<>(k);
        this.k = k;
    }

    // 时间复杂度：O(logk)
    public int add(int val) {
        if (data.size() < k) {
            data.add(val);
        } else if (val > data.peek()) {
            data.remove();
            data.add(val);
        }
        return data.peek();
    }

    public static void main(String[] args) {
        KthLargest4 kl = new KthLargest4(3);
        System.out.println(kl.add(5));
        System.out.println(kl.add(6));
        System.out.println(kl.add(7));
        System.out.println(kl.add(8));
    }
}
