package algo.binarysearch.train;

public class _35_SearchInsert {
    // 思路二 在循环体中排除一定不存在目标元素的区间
    // 查找第一个大于等于目标值的下标
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        // 二分查找第一个大于等于 target 的索引
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // 思路一 在循环体中查找目标元素
    // 查找第一个大于等于目标值的下标
    public int searchInsert1(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        // 二分查找第一个大于等于 target 的索引
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
