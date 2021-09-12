package _2_day;

import java.util.Arrays;

public class _135_distribute_candy {
    // 一个数组 + 两次遍历 O(n)
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2right = new int[n];
        Arrays.fill(left2right, 1);
        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        int sum = 0;
        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            sum += Math.max(left2right[i], right);
        }
        return sum;
    }

    // 一个数组 + 三次遍历 O(n)
    public int candy6(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int candy : candies) sum += candy;
        return sum;
    }

    // 一个数组 + 三次遍历 O(n)
    public int candy5(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int candy : candies) sum += candy;
        return sum;
    }

    // 两个数组 + 两次遍历 O(n)
    public int candy4(int[] ratings) {
        int n = ratings.length;
        int[] left2right = new int[n];
        Arrays.fill(left2right, 1);
        int[] right2left = new int[n];
        Arrays.fill(right2left, 1);
        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

    // 两个数组 + 三次遍历 O(n)
    public int candy3(int[] ratings) {
        int n = ratings.length;
        int[] left2right = new int[n];
        Arrays.fill(left2right, 1);
        int[] right2left = new int[n];
        Arrays.fill(right2left, 1);
        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1 && ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left2right[i], right2left[i]);
        }
        return sum;
    }

    // 暴力解法 O(n^2)
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < n; i++) {
                if (i != n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                }
            }
        }
        int sum = 0;
        for (int candy : candies) sum += candy;
        return sum;
    }

    // 暴力解法 O(n^2)
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < n; i++) {
                if (i != n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }
                if (i != 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                }
            }
        }
        int sum = 0;
        for (int candy : candies) sum += candy;
        return sum;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1,6,10,8,7,3,2};
        int[] arr = new int[]{1,3,4,5,2};
        int res = new _135_distribute_candy().candy(arr);
        System.out.println(res);
    }
}
