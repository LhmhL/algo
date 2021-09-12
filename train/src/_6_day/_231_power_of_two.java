package _6_day;

public class _231_power_of_two {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        // 当 n = -2147483648 的时候，-n 就会溢出
        long x = n;
        return (x & -x) == x;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        // 当 n = -2147483648 的时候，n - 1 就会溢出
        long x = n;
        return (x & (x - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n = n / 2;
        return n == 1;
    }
}
