package _7_day;

import java.util.Arrays;
import java.util.Comparator;

public class _179_largest_number {
    public String largestNumber(int[] nums) {
        // 1. 将int数组转成字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        // 2. 降序排列
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return yx.compareTo(xy);
            }
        });
        // 3. 转成字符串
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public String largestNumber1(int[] nums) {
        // 1. 降序排列
        sort(nums, 0, nums.length - 1);
        // 2. 转成字符串
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = data[hi];
        int less = lo;
        int great = hi;
        int i = lo;
        while (i <= great) {
            String xy = data[i] + "" + pivot;
            String yx = pivot + "" + data[i];
            if (xy.compareTo(yx) > 0) {
                swap(data, i, less);
                less++;
                i++;
            } else if (xy.compareTo(yx) < 0) {
                swap(data, i, great);
                great--;
            } else {
                i++;
            }
        }
        sort(data, lo, less - 1);
        sort(data, great +1, hi);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
