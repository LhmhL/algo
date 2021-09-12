package algo.binarysearch;

public class BasicBinarySearch {
    // 时间复杂度：O(logn)
    // 空间复杂度：O(1)
    // 思路一 在循环体中查找目标元素
    public boolean contains(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // left + right 会溢出
            // 整数的最大值：2^31 - 1 = 2147483647
            int mid = left + (right -  left) / 2;
            // >>> 无符号右移
            // int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                right = mid - 1; // 下一次搜索区间：[left...mid - 1]
            } else { // target > nums[mid]
                left = mid + 1; // 下一次搜索区间：[mid + 1...right]
            }
        }
        // left > right ：没有元素
        return false;
    }

    // 时间复杂度：O(logn)
    // 空间复杂度：O(logn)
    // 思路一 在循环体中查找目标元素 递归 基本不用
    public boolean containsR(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return containsR(nums, 0, nums.length - 1, target);
    }

    private boolean containsR(int[] nums, int left, int right, int target) {
        if (left > right) return false;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return true;
        if (target < nums[mid]) {
            return containsR(nums, left, mid - 1, target);
        } else {
            return containsR(nums, mid + 1, right, target);
        }
    }
}
