package _6_day;

public class _461_hamming_distance {
    public int hammingDistance(int x, int y) {
        // 使用异或计算 x 和 y 的不同位，结果中位为 1 ，说明这位不同
        int diff = x ^ y;
        // 计算 diff 中位 1 个数
        int res = 0;
        while (diff != 0) {
            diff = diff & (diff - 1);
            res++;
        }
        return res;
    }
}
