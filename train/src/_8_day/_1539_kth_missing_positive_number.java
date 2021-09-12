package _8_day;

public class _1539_kth_missing_positive_number {
    // 元素 a[i] 前面缺失数的个数为：a[i] - i - 1
    // 找到第一个前面缺失数的个数大于等于 k 的元素
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        if (arr[0] > k) return k;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int leftMissCnt = arr[left - 1] - (left - 1) - 1;
        return arr[left - 1] + (k - leftMissCnt);
    }

    public int findKthPositive0(int[] arr, int k) {
        int n = arr.length - 1;
        int lastMissCnt = arr[n] - n - 1;
        if (lastMissCnt < k)
            return arr[n] + (k - lastMissCnt);
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - mid - 1 < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int currMissCnt = arr[left] - left - 1;
        return arr[left] - (currMissCnt - k) - 1;
    }

    // 时间复杂度：O(n + k)
    public int findKthPositive1(int[] arr, int k) {
        int currNum = 1;
        int missCnt = 0;
        int lastMissNum = -1;
        int i = 0;
        while (missCnt < k) {
            if (currNum == arr[i]) {
                if (i + 1 <arr.length) i++;
//                i = (i + 1 < arr.length) ? i + 1 : i;
            } else {
                missCnt++;
                lastMissNum = currNum;
            }
            currNum++;
        }
        return lastMissNum;
    }
}
