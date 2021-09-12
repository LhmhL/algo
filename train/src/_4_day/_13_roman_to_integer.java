package _4_day;

public class _13_roman_to_integer {
    public int romanToInt(String s) {
        int res = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (pre < curr) {
                res -= pre;
            } else {
                res += pre;
            }
            pre = curr;
        }
        res += pre;
        return res;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        int res = new _13_roman_to_integer().romanToInt("CCXCIX");
        System.out.println(res);
    }
}
