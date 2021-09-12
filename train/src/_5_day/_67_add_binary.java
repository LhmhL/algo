package _5_day;

public class _67_add_binary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int x = l1 < 0 ? 0 : a.charAt(l1) - '0';
            int y = l2 < 0 ? 0 : b.charAt(l2) - '0';
            int sum = x + y + carry;
            res.append(sum % 2);
            carry = sum / 2;
            l1--;
            l2--;
        }
        if (carry != 0) res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new _67_add_binary().addBinary("11","11");
        System.out.println(res);
    }
}
