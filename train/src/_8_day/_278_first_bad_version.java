package _8_day;

public class _278_first_bad_version {
    // 来判断版本号 version 是否在单元测试中出错
    boolean isBadVersion(int version) {
        // 这里面的逻辑是随机的返回 true 和 false
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isBadVersion(left) ? left : -1;
    }

    public int firstBadVersion1(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                if (mid == 1 || !isBadVersion(mid - 1)) return mid;
                else right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
