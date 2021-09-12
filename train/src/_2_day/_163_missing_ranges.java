package _2_day;

import java.util.ArrayList;
import java.util.List;

public class _163_missing_ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums[0] == lower + 1) {
            res.add(String.valueOf(lower));
        }
        if (nums[0] > lower + 1) {
            res.add((lower) + "->" + (nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 2) {
                res.add(String.valueOf(nums[i - 1] + 1));
            }
            if (nums[i] > nums[i - 1] + 2) {
                res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            }
        }
        if (upper == nums[nums.length - 1] + 1) {
            res.add(String.valueOf(upper));
        }
        if (upper > nums[nums.length - 1] + 1) {
            res.add((nums[nums.length - 1] + 1) + "->" + upper);
        }
        return res;
    }

    public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int pre = lower - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre + 2) {
                res.add(String.valueOf(pre + 1));
            }
            if (nums[i] > pre + 2) {
                res.add((pre + 1) + "->" + (nums[i] - 1));
            }
            pre = nums[i];
        }
        if (upper == pre + 1) {
            res.add(String.valueOf(pre + 1));
        }
        if (upper > pre + 1) {
            res.add((pre + 1) + "->" + upper);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,3,50,74};
        List<String> res = new _163_missing_ranges().findMissingRanges1(arr,-1,76);
        System.out.println(res);
    }
}
