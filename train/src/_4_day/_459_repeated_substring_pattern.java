package _4_day;

public class _459_repeated_substring_pattern {
    // 字符串匹配法
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    // 旋转数组
    public boolean repeatedSubstringPattern3(String s) {
        for (int len = 1; len * 2 <= s.length(); len++) {
            String str = rotate(s.toCharArray(), len);
            if (s.equals(str)) return true;
        }
        return false;
    }

    private String rotate(char[] chars, int k) {
        int n = chars.length;
        k = k % n;
        reverse(chars, 0, n - 1);
        reverse(chars, 0, k - 1);
        reverse(chars, k, n - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
    }

    // 双指针模拟
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        for (int len = 1; len * 2 <= n; len++) {
            if (n % len == 0) {
                int i = 0;
                int j = len;
                for (; j < n; j++, i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        break;
                    }
                }
                if (j == n) return true;
            }
        }
        return false;
    }

    // 双指针模拟
    public boolean repeatedSubstringPattern1(String s) {
        int n = s.length();
        for (int len = 1; len * 2 <= n; len++) {
            if (n % len == 0) {
                boolean matched = true;
                for (int i = 0, j = len; j < n; j++, i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        matched = false;
                        break;
                    }
                }
                if (matched) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new _459_repeated_substring_pattern().repeatedSubstringPattern2("abcabcabc");
        System.out.println(res);
    }
}
