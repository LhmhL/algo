package _6_day;

public class _201_bitwise_and_of_numbers_range {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }

    public int rangeBitwiseAnd2(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    // 0 <= left <= right <= 2^31 - 1
    // 超时
    public int rangeBitwiseAnd1(int left, int right) {
        int res = left;
        for (int i = left + 1; i <= right; i++) {
            res &= i;
        }
        return res;
    }
}
