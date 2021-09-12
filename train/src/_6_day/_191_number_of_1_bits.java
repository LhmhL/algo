package _6_day;

public class _191_number_of_1_bits {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
//            if ((n & 1) == 1) {
//                res++;
//            }
            // 有符号右移和无符号右移都是一样的
            // 因为我们只右移 32 位
            n >>= 1;
        }
        return res;
    }

    public int hammingWeight1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }
}
