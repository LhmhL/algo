package _2_day;

import java.util.ArrayList;
import java.util.List;

public class _228_summary_ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i;
            while (i < nums.length - 1 && nums[i + 1] - nums[i] == 1) i++;
            int high = i;
            i++;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low < high) {
                sb.append("->");
                sb.append(nums[high]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i;
            i++;
            while (i < nums.length && nums[i] - nums[i - 1] == 1) i++;
            int high = i - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[low]);
            if (low < high) {
                sb.append("->");
                sb.append(nums[high]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2,3,4,6,8,9};
        List<String> res = new _228_summary_ranges().summaryRanges(arr);
        System.out.println(res);
    }
}
