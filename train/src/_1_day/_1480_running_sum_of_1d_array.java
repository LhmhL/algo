package _1_day;

public class _1480_running_sum_of_1d_array {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }

    public int[] runningSum1(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }
            prefixSum[i] = sum;
        }
        return prefixSum;
    }
}
