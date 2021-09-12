package _10_day;

import java.util.ArrayDeque;

public class LeftLastLarger {
    /*
        题目：找出数组中左边离我最近比我大的元素
        一个整数数组 nums，找到每个元素：左边第一个比我小的下标位置，没有则用 -1 表示。
        输入：[3, 2]
        输出：[-1, 0]

        解释：
            因为元素 2 的左边离我最近且比我小的位置应该是 nums[0]，
            第一个元素 1 左边没有比 1 小的元素，所以应该输出 -1。
    */

    public int[] findLeftLastLarge(int[] nums) {
        int[] res = new int[nums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 时间复杂度：O(n)
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            // 单调递减栈
            while (!stack.isEmpty() && x > nums[stack.peek()]) {
                res[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i); // 索引
        }
        while (!stack.isEmpty()) {
            res[stack.peek()] = -1;
            stack.pop();
        }
        return res;
    }
}
