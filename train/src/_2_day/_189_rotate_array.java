package _2_day;

import java.util.Arrays;

public class _189_rotate_array {
    // 方案三：数组旋转
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    // 方案二：环状替换
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int start = 0;
        while (count < n) {
            int curr = start;
            int prev = nums[start];
            // 循环替换
            do {
                int next = (curr + k) % n;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                curr = next;
                count++;
            } while (start != curr);
            start++;
        }
    }

    // 方案二：环状替换
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int start = 0; count < n; start++) {
            int curr = start;
            int prev = nums[start];
            // 循环替换
            do {
                int next = (curr + k) % n;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                curr = next;
                count++;
            } while (start != curr);
        }
    }

    // 方案一：使用额外数组
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % n;
            newArr[index] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        new _189_rotate_array().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
