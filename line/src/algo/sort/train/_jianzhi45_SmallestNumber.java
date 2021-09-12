package algo.sort.train;

import java.util.Arrays;
import java.util.Comparator;

public class _jianzhi45_SmallestNumber {
    public String smallestNumber(int[] nums) {
        // 1. 将int数组转成字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        // 2. 升序排序
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String xy = x + y;
                String yx = y + x;
                return xy.compareTo(yx);
            }
        });
        // 3. 转成字符串
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,30,34,5,9};
        String res = new _jianzhi45_SmallestNumber().smallestNumber(arr);
        System.out.println(res);
    }
}
