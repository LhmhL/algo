package _6_day;

public class _29_divide_two_integers {
    public int divide(int dividend, int divisor) {
        // -2147483648 ÷ (-1) = 2147483648
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        // 计算结果的符号
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            // 如果使用 (a >>> i) >= b 的话，当 b = -2147483648 时会出错
            // 因为 Math.abs(-2147483648) = -2147483648
            // 如果 (a >>> i) >= -2147483648，这个永远返回 true
            // 而 (a >>> i) - (-2147483648) >= 0 返回的是 false，这个是我们需要的，
            // 因为任何整形都是小于 2147483648 的，这个我们需要将 -2147483648 看成 2147483648
            // 任何整数减去 -2147483648 都是等于 -2147483648 的，也就是小于零，
            // 所以可以认为任何整数都比 -2147483648 小，
            // 从而可以认为任何整数都小于 2147483648，这里有点绕，可以仔细揣摩下
            if ((a >>> i) - b >= 0) {
                a = a - (b << i);
                res = res + (1 << i);
            }
        }
        // 当 res == 1 << 31 的时候， -res 也等于 1 << 31
        return sign * res;
    }

    // 时间复杂度：O(log(n^2))
    public int divide2(int dividend, int divisor) {
        // -2147483648 ÷ (-1) = 2147483648
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        // 计算结果的符号
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor);
        int res = 0;
        while (a - b >= 0) {
            long tmp = b;
            int m = 1;
            while (tmp << 1 <= a) {
                tmp <<= 1;
                m <<= 1;
            }
            a -= tmp;
            res += m;
        }
        return sign * res;
    }

    // 时间复杂度：O(n) ：超时
    public int divide1(int dividend, int divisor) {
        // -2147483648 ÷ (-1) = 2147483648
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        // 计算结果的符号
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        int a = Math.abs(dividend), b = Math.abs(divisor);
        int res = 0;
        while (a - b >= 0) {
            res++;
            a -= b;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        // 最小值 -2147483648 的绝对值还是 -2147483648
        System.out.println(Math.abs(-2147483648));
        // 1 << 31 和 -1 << 31 都是 -2147483648
        System.out.println(1 << 31);
        System.out.println(-1 << 31);
        int res = new _29_divide_two_integers().divide2(-2147483648, -2147483648);
        System.out.println(res);
    }
}
