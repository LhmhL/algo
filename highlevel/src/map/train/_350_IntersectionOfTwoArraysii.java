package map.train;

import java.util.*;

public class _350_IntersectionOfTwoArraysii {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // O(mlogm)
        Arrays.sort(nums2); // O(nlogn)
        int i = 0, j = 0;
        int k = 0;
        // O(m + n)
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                j++;
                k++;
            } else if (nums1[i] < nums2[i]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // O(mlogm)
        Arrays.sort(nums2); // O(nlogn)
        List<Integer> resultList = new ArrayList<>();
        int i = 0, j = 0;
        // O(m + n)
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                resultList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[i]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[resultList.size()];
        int k = 0;
        for (int num : resultList) {
            res[k++] = num;
        }
        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        // 使用 Map 记录数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        // 使用 Map 记录数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num ,map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                if (map.get(num) > 0) {
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
