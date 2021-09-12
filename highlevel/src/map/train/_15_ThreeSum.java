package map.train;

import java.util.*;

public class _15_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^2)
        for (int i = 0; i < nums.length - 2; i++) {
            // 忽略后面与前面重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 在 i + 1 ... nums.length - 1 中查找相加等于 -nums[i] 的两个数
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res; // O(1)
    }

    // 双指针
    public List<List<Integer>> threeSum3(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^2)
        for (int i = 0; i < nums.length; i++) {
            // 在 i + 1 ... nums.length - 1 中查找相加等于 -nums[i] 的两个数
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(res); // O(n)
    }

    // 双指针
    public List<List<Integer>> threeSum4(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^2)
        for (int i = 0; i < nums.length; i++) {
            // 在 i + 1 ... nums.length - 1 中查找相加等于 -nums[i] 的两个数
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> tmp = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!set.contains(tmp)) {
                        set.add(tmp);
                        res.add(tmp);
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res; // O(1)
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(res); // O(n)
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!set.contains(tmp)) {
                            set.add(tmp);
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        return res; // O(1)
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new _15_ThreeSum().threeSum(nums));
    }
}
