package algo.binarysearch;

public class BinarySearch {
    // 思路一 在循环体中查找目标元素
    // 查找第一个等于目标值的下标
    public int firstTargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 符合下面的两个条件之一就返回 mid ：
                // 1. mid 是数组的第一个元素
                // 2. mid 前面的那个元素不等于 target
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else right = mid - 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 思路一 在循环体中查找目标元素
    // 查找第一个大于等于目标值的下标
    public int firstGETargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                // 符合下面的两个条件之一就返回 mid ：
                // 1. mid 是数组的第一个元素
                // 2. mid 前面的那个元素小于 target
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else right = mid - 1;
            } else { // target > nums[mid]
                left = mid + 1;
            }
        }
        return -1;
    }

    // 思路一 在循环体中查找目标元素
    // 查找最后一个等于目标值的下标
    public int lastTargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                // 符合下面的两个条件之一就返回 mid ：
                // 1. mid 是数组的最后一个元素
                // 2. mid 后面的那个元素不等于 target
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                else left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 思路一 在循环体中查找目标元素
    // 查找最后一个小于等于目标值的下标
    public int lastLETargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                // 符合下面的两个条件之一就返回 mid ：
                // 1. mid 是数组的最后一个元素
                // 2. mid 后面的那个元素大于 target
                if (mid == nums.length - 1 || nums[mid + 1] > target) return mid;
                else left = mid + 1;
            } else { // target < nums[mid]
                right = mid - 1;
            }
        }
        return -1;
    }
}
