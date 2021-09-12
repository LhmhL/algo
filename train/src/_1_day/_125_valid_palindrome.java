package _1_day;

public class _125_valid_palindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 忽略左边无效字符
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 忽略右边无效字符
            while (left < right &&
                    !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) !=
                        Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
