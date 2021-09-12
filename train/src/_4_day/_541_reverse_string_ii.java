package _4_day;

public class _541_reverse_string_ii {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int start = 0; start < s.length(); start += 2 * k) {
            int left = start;
            // 主要是判断后面 k个字符是否超过数组的长度，如果超过，就将后面的所有字符反转
            int right = Math.min(left + k - 1, s.length() - 1);
            while (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String res = new _541_reverse_string_ii().reverseStr("abcdefg",2);
        System.out.println(res);
    }
}
