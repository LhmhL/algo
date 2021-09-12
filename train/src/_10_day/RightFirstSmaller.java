package _10_day;

import java.util.ArrayDeque;

public class RightFirstSmaller {
    /*
        题目：找出数组中右边第一个比我小的元素
        一个整数数组 nums，找到每个元素：右边第一个比我小的下标位置，没有则用 -1 表示。
        输入：[5, 2]
        输出：[1, -1]

        解释：
            因为元素 5 的右边离我最近且比我小的位置应该是 nums[1]，
            最后一个元素 2 右边没有比 2 小的元素，所以应该输出 -1。
    */

    public int[] findRightSmall(int[] nums) {
        int[] res = new int[nums.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // 时间复杂度：O(n)
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // 单调递增栈
            while (!stack.isEmpty() && x < nums[stack.peek()]) {
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
