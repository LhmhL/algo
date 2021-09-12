package _4_day;

public class _8_string_to_integer_atoi {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        // 1. 丢弃前导空格
        while (i < s.length() && chars[i] == ' ') i++;
        if (i == s.length()) return 0;
        // 2. 检查 + 和 - 是否存在
        int sign = 1;
        if (chars[i] == '-' || chars[i] == '+') {
            sign = chars[i] == '-' ? -1 : 1;
            i++;
        }
        // 3. 计算结果，并且检查是否溢出
        int base = 0;
        while (i < s.length() && chars[i] >= '0' && chars[i] <= '9') {
            // 检查
            // 2147483647    -2147483648
            if (base > Integer.MAX_VALUE / 10 ||
                    (base == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7)) {
                if (sign > 0) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base = base * 10 + (chars[i] - '0');
            i++;
        }
        return sign * base;
    }

    public static void main(String[] args) {
        String str = "-213";
        int i = 0;
        int sign = 1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        int base = 0;
        while (i < str.length()) {
            base = base * 10 + (str.charAt(i) - '0');
            i++;
        }
        System.out.println(sign * base);
        int res = new _8_string_to_integer_atoi().myAtoi("2147483647");
        System.out.println(res);
        res = new _8_string_to_integer_atoi().myAtoi("-2147483648");
        System.out.println(res);
    }
}
