package _1_day;

import java.util.ArrayList;
import java.util.List;

public class _448_find_all_disappeared_in_an_array {
    public List<Integer> findDisappeared1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) res.add(i + 1);
        }
        return res;
    }

    public List<Integer> findDisappeared(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = new _448_find_all_disappeared_in_an_array().findDisappeared(arr);
        System.out.println(res);
    }
}
