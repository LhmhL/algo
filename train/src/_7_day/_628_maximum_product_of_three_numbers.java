package _7_day;

public class _628_maximum_product_of_three_numbers {
    public int maximumProduct(int[] nums) {
        // 最小值、第二小值
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大值、第二大值、第三大值
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}
