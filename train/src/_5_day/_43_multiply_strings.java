package _5_day;

public class _43_multiply_strings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = res[i + j + 1] + x * y;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        int m = num1.length();
        int n = num2.length();
        // 处理乘数的每一位
        for (int i = n - 1; i >= 0; i--) {
            StringBuilder currRes = new StringBuilder();
            // 对当前位的后面补 0
            for (int j = n - 1; j > i; j--) {
                currRes.append("0");
            }
            // 当前位的值
            int y = num2.charAt(i) - '0';
            int carry = 0;
            // 处理被乘数的每一位
            for (int j = m - 1; j >= 0; j--) {
                // 将当前位的值和被乘数的每一位进行相乘
                int x = num1.charAt(j) - '0';
                int product = x * y + carry;
                currRes.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) currRes.append(carry);
            // 将乘数的每一位和被乘数相乘的结果累加
            res = addStrings(res, currRes.reverse().toString());
        }
        return res;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0) {
            int x = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int y = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i1--;
            i2--;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new _43_multiply_strings().multiply("123","321");
        System.out.println(res);
    }
}
