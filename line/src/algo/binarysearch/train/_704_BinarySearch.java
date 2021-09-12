package algo.binarysearch.train;

public class _704_BinarySearch {
    // 思路二 在循环体中排除一定不存在目标元素的区间
    // 方法三 基本不用
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间是 [left...right] 中的每个元素
        while (left + 1 < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid])
                right = mid;
            else
                left = mid;
        }
        // 循环结束后：left + 1 == right
        // 需要后处理，因为在循环中，还有两个个元素没有处理
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    // 思路二 在循环体中排除一定不存在目标元素的区间
    // 方法二 适用于查找最后一个等于目标值的下标
    // 查找最后一个于小于等于目标值的下标 return right
    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间是 [left...right] 中的每个元素
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid;
        }
        // 循环结束后：left == right
        // 需要后处理，因为在循环中，还有一个元素没有处理
        if (nums[left] == target) return left;
        return -1;
    }

    // 思路二 在循环体中排除一定不存在目标元素的区间
    // 方法一 适用于查找第一个等于目标值的下标
    // 查找第一个大于等于目标值的下标 return left
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间是 [left...right] 中的每个元素
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid;
        }
        // 循环结束后：left == right
        // 需要后处理，因为在循环中，还有一个元素没有处理
        if (nums[left] == target) return left;
        return -1;
    }

    // 思路一 在循环体中查找目标元素
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        // 搜索区间是 [left...right] 中的每个元素
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                // 下一轮搜索区间是：[left...mid - 1]
                right = mid - 1;
            else
                // 下一轮搜索区间是：[mid + 1...right]
                left = mid + 1;
        }
        // 循环结束后：left > right
        // 没有任何的数据需要后处理
        return -1;
    }
}
