package _4_day;

public class _58_length_of_last_word {
    // 从右往左遍历
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    // 从左往右遍历
    public int lengthOfLastWord1(String s) {
        int n = s.length();
        int res = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            if (s.charAt(start) == ' ') {
                start++;
                end++;
            } else {
                while (end < n && s.charAt(end) != ' ') end++;
                res = end - start;
                while (end < n && s.charAt(end) == ' ') end++;
                if (end < n && s.charAt(end) != ' ') {
                    start = end;
                }
            }
//            while (start < n && end < n && s.charAt(start) == ' ') {
//                start++;
//                end++;
//            }
//            while (end < n && s.charAt(end) != ' ') end++;
//            res = end - start;
//            while (end < n && s.charAt(end) == ' ') end++;
//            if (end < n && s.charAt(end) != ' ') {
//                start = end;
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new _58_length_of_last_word().lengthOfLastWord("hello word");
        System.out.println(res);
    }
}
