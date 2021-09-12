package _6_day;

public class _1318_minimum_flips_a_or_b_equal_to_c {
    public int minFlips(int a, int b, int c) {
        int aOrb = a | b;
        int equal = aOrb ^ c;
        if (equal == 0) return 0;
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int mask = 1 << i;
            // a | b 和 c 的第 i 位不同，那么至少需要翻转 1 次
            if ((equal & mask) > 0) {
                // 如果 a 和 b 的第 i 位是 1，且 c 的第 i 位是 0，那么需要翻转 2 次
                if ((c & mask) == 0 && ((a & mask) == (b & mask))) {
                    res += 2;
                } else {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new _1318_minimum_flips_a_or_b_equal_to_c().minFlips(2,6,5);
        System.out.println(res);
    }
}
