package _5_day;

public class _233_number_of_digit_one {
    // O(logn)
    public int countDigitOne(int n) {
        int res = 0;
        for (long i = 1; i <= n; i *= 10) {
            // (n/10)*1 + min(max((n%10 - 1 + 1), 0), 1)
            // (n/100)*10 + min(max((n%100 - 10 + 1), 0), 10)
            // (n/1000)*100 + min(max((n%1000 - 100 + 1), 0), 100)
            long divider = i * 10;
            res += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        return res;
    }

    // 暴力超时
    public int countDigitOne1(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            int tmp = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') tmp++;
            }
            res += tmp;
        }
        return res;
    }
}
