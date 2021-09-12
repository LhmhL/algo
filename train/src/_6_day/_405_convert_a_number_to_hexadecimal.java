package _6_day;

public class _405_convert_a_number_to_hexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String res = "";
        while (num != 0) {
            int index = num & 15;
            res = hexChars[index] + res;
            num >>>= 4;
        }
        return res;
//        StringBuilder sb = new StringBuilder();
//        while (num != 0) {
//            int index = num & 15;
//            sb.append(hexChars[index]);
//            num >>>= 4;
//        }
//        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new _405_convert_a_number_to_hexadecimal().toHex(222);
        System.out.println(res);
    }
}
