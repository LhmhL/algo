package _4_day;

public class _345_reverse_vowels_of_a_string {
    public String reverseVowels(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !isVowel(chars[left])) left++;
            while (left < right && !isVowel(chars[right])) right--;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        String res = new _345_reverse_vowels_of_a_string().reverseVowels("hello");
        System.out.println(res);
    }
}
