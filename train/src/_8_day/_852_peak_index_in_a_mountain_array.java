package _8_day;

public class _852_peak_index_in_a_mountain_array {
    // 2. 二分查找
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) { // 上坡
                left = mid + 1;
            } else { // 下坡
                right = mid;
            }
        }
        return left;
    }

    // 1. 线性查找
    public int peakIndexInMountainArray1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }
}
