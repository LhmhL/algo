package _7_day;

public class _50_pow_x_n {
    // 快速幂 + 迭代
    // 时间：O(32)
    // 空间：O(1)
    public double myPow(double x, int n) {
        long p = n;
        if (p < 0) {
            x = 1 / x;
            p = -p;
        }
        double res = 1;
        while (p != 0) {
            if ((p & 1) == 1) res *= x;
            x *= x;
            p >>= 1;
        }
        return res;
    }

    // 快速幂 + 递归
    // 时间：O(logn)
    // 空间：O(logn)
    public double myPow2(double x, int n) {
        long p = n;
        if (p < 0) {
            x = 1 / x;
            p = -p;
        }
        return quickPow(x, p);
    }

    private double quickPow(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        long mid = n / 2;
        double y = quickPow(x, mid);
        return n % 2 == 0 ? y * y : x * y * y;
    }

    // O(n) --> 超时
    public double myPow1(double x, int n) {
        long p = n;
        if (p < 0) {
            x = 1 / x;
            p = -p;
        }
        double res = 1;
        for (int i = 0; i < p; i++) {
            res *= x;
        }
        return res;
    }
}
