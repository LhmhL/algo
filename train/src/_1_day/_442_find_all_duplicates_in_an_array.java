package _1_day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _442_find_all_duplicates_in_an_array {
    public List<Integer> findDuplicates2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n;
            nums[index] += n;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) res.add(i + 1);
        }
        return res;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(nums[i]));
            else
                nums[index] = -nums[index];
        }
        return res;
    }

    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // 查找map中value值=2的key值，该怎么查找？
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 2) {
                map.put(nums[i], 1);
                res.add(nums[i]);
            }
        }
        return res;
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 2) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = new _442_find_all_duplicates_in_an_array().findDuplicates(arr);
        System.out.println(res);
    }
}
