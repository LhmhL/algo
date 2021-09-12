package _8_day;

public class _zijie_CutWood {
    // 暴力解法：将 1 到最大元素值作为木头的长度，针对每个长度，做下面的事情：
    //          1. 计算所有元素可以截取多少个这个长度的木头
    //          2. 如果截取这个长度的木头数比 k 大，则更新最大的 m 值
    // 时间复杂度：O(maxValue * n)
    // 空间复杂度：O(1)
    public int cutWood1(int k, int[] nums) {
        int maxValue = nums[0];
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int maxM = 0;
        for (int m = 1; m <= maxValue; m++) {
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                cnt += nums[i] / m;
            }
            if (cnt >= k) {
                maxM = Math.max(maxM, m);
            }
        }
        return maxM;
    }

    /*
        优化思路
        暴力解法是在区间 [1...maxValue] 中，针对每个长度来计算能截取的木头数
        我们可以先计算 [1...maxValue] 的中间值 mid，然后计算 nums 中可以截取长度为 mid 的木头数量 cnt
        如果 cnt >= k 的话，说明我们可以去看看截取长度比 mid 大的情况，也就是将区间缩小一半至 [mid...maxValue]
        否则，我们可以看左半部分区间，即 [1...mid - 1]
        时间复杂度：O(nlog(maxValue))
        空间复杂度：O(1)
     */
    public int cutWood(int k, int[] nums) {
        int maxValue = nums[0];
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int left = 1, right = maxValue;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (calWoodCnt(mid, nums) >= k) left = mid;
            else right = mid - 1;
//            if (calWoodCnt(mid, nums) < k) right = mid - 1;
//            else left = mid;
        }
        return left;
    }

    public int cutWood0(int k, int[] nums) {
        int maxValue = nums[0];
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }
        int left = 1, right = maxValue;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (calWoodCnt(mid, nums) > k) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private int calWoodCnt(int m, int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] / m;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int res = new _zijie_CutWood().cutWood(5,new int[]{4,7,2,10,5});
        System.out.println(res);
    }
}
