package _5_day;

public class _9_palindrome_number {
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int res = 0;
        while (res < x) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        // 当数字长度为奇数时，我们可以通过 res/10 去除处于个位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，res = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return res == x || x == res / 10;
    }

    public boolean isPalindrome2(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int res = 0;
        int y = x;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            // 反转整数的时候，可能出现溢出
            res = res * 10 + pop;
        }
        return y == res;
    }

    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
