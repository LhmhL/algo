package _7_day;

import java.util.Arrays;

public class _1365_smaller_numbers_than_current_number {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i < 101; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        // 维护元素值 -> 索引关系
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        // 按照元素值排序
        Arrays.sort(data, (o1, o2) -> o1[0] - o2[0]);
        int[] res = new int[n];
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (data[i][0] != data[i - 1][0]) {
                cnt = i;
            }
            res[data[i][1]] = cnt;
        }
        return res;
    }

    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            res[i] = cnt;
        }
        return res;
    }
}
