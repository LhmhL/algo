package algo.binarysearch.train;

public class _34_SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int firstTargetIndex = searchFirstTargetIndex(nums, target);
        if (firstTargetIndex == -1) {
            return new int[]{-1, -1};
        }
        int lastTargetIndex = searchLastTargetIndex(nums, target);
        return new int[]{firstTargetIndex, lastTargetIndex};
    }

    // 思路二 在循环体中排除一定不存在目标元素的区间
    // 查找第一个等于目标值的下标
    private int searchFirstTargetIndex(int[] nums, int target) {
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
        if (nums[left] == target) return left;
        return -1;
    }

    // 思路二 在循环体中排除一定不存在目标元素的区间
    // 查找最后一个等于目标值的下标
    private int searchLastTargetIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        return -1;
    }

    // 思路一 在循环体中查找目标元素
    // 查找第一个等于目标值的下标
    private int searchFirstTargetIndex1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
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
    // 查找最后一个等于目标值的下标
    private int searchLastTargetIndex1(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) return mid;
                else left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
