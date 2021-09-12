package map.train;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：答案中不可以包含重复的四元组。
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 *
 */
public class _18_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^3)
        for (int i = 0; i < nums.length - 3; i++) {
            // 忽略后面与前面重复的元素
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                // 忽略后面与前面重复的元素
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int partSum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = partSum + nums[left] + nums[right];
                    if (sum == target) {
                        // 去重
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[++left]);
                        while (left < right && nums[right] == nums[--right]);
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res; // O(1)
    }

    // 双指针
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int partSum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = partSum + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

        }
        return new ArrayList<>(res); // O(n)
    }

    // 双指针
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)
        // O(n^3)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int partSum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = partSum + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
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
        }
        return res; // O(1)
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 0, -2, 2};
        System.out.println(new _18_FourSum().fourSum(nums, 0));
    }
}
