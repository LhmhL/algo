package _4_day;

public class _557_reverse_words_in_a_string_iii {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        while (left < n) {
            if (chars[left] != ' ') {
                int right = left;
                while (right + 1 < n && chars[right + 1] != ' ') right++;
                reverseWord(chars, left, right);
                left = right + 1;
            } else {
                left++;
            }
//            while (left < n && chars[left] == ' ') left++;
//            int right = left;
//            while (right + 1 < n && chars[right + 1] != ' ') right++;
//            reverseWord(chars, left, right);
//            left = right + 1;
        }
        return new String(chars);
    }

    private void reverseWord(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String res = new _557_reverse_words_in_a_string_iii().reverseWords("hello word");
        System.out.println(res);
    }
}
