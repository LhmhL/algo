package algo.binarysearch.train;

public class _jianzhi11_MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) { // 左边有序，最小值在右边
                left = mid + 1;
            } else if (nums[mid] < nums[right]) { // 右边有序，最小值下标有可能是mid
                right = mid;
            } else { // 含有重复元素，right = mid有可能错过最小值，防止错过最小值
                right--;
            }
        }
        return nums[left];
    }

    public int findMin1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
