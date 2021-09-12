package _2_day;

import java.util.Arrays;
import java.util.List;

public class _31_next_permutation {
    public void nextPermutation(int[] nums) {
        // 1. 找到尽量靠右的【较小数】
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        // 2. 如果找到了【较小数】
        if (i >= 0) {
            // 找到尽量靠右的比【较小数】大的【较大数】
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) j--;
            // 交换【较小数】和【较大数】
            swap(nums, i, j);
        }
        // 3. 反转【较小数】之后的所有元素
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{4,5,2,6,3,1};
        int[] arr = new int[]{6,5,4,3,2,1};
        new _31_next_permutation().nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
