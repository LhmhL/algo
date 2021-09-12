package _4_day;

public class _1119_remove_vowels_from_a_string {
    public String removeVowels(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!isVowel(c)) res.append(c);
        }
        return res.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String res = new _1119_remove_vowels_from_a_string().removeVowels("hello");
        System.out.println(res);
    }
}
