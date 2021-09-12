package algo.twopoint;

public class ReverseString {
    // 时间复杂度 O(n/2) = O(n)
    // 空间复杂度 O(1)
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;

            left++;
            right--;
        }
        return new String(chars);
    }

    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public String reverseString2(String s) {
        char[] chars = s.toCharArray();
        char[] tmp = new char[chars.length];
        int j = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            tmp[j] = chars[i];
            j--;
        }
        return new String(tmp);
    }

    public String reverseString1(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(new ReverseString().reverseString(s));
    }
}
