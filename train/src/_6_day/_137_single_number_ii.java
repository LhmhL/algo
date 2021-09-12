package _6_day;

import java.util.HashSet;
import java.util.Set;

public class _137_single_number_ii {
    public int singleNumber(int[] nums) {
        int res = 0;
        //int类型有32位，统计每一位1的个数
        for (int i = 0; i < 32; i++) {
            //统计第 i 位中 1 的个数
            int oneCount = 0;
            for (int num : nums) {
                oneCount += (num >> i) & 1;
            }
            //如果1的个数不是3的倍数
            //说明那个只出现一次的数字的二进制位中在这一位是1
            if (oneCount % 3 == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }

    public int singleNumber2(int[] nums) {
        int once = 0, twice = 0;
        for (int num : nums) {
            once = (once ^ num) & ~twice;
            twice = (twice ^ num) & ~once;
        }
        return once;
    }

    public int singleNumber1(int[] nums) {
        Set<Integer> once = new HashSet<>();
        Set<Integer> twice = new HashSet<>();
        for (int num : nums) {
            if (once.contains(num)) {
                once.remove(num);
            } else if (!twice.contains(num)) {
                once.add(num);
            }
            if (twice.contains(num)) {
                twice.remove(num);
            } else if (!once.contains(num)) {
                twice.add(num);
            }
        }
        return once.iterator().next();
    }
}
