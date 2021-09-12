package _8_day;

public class _69_sqrt_x {
    // 二分查找
    // 时间复杂度：O(logx)
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // 时间复杂度：O(x)
    public int mySqrt1(int x) {
        int res = -1;
        for (int k = 0; k <= x; k++) {
            if ((long)k * k <= x) {
                res = k;
            }
        }
        return res;
    }
}
