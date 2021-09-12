package algo.binarysearch.train;

public class _852_PeakIndexInMountainArray {
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

    public int peakIndexInMountainArray1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
