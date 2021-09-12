package _5_day;

public class _66_add_to_array_plus_one {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
//            if (digits[i] == 10) {
//                digits[i] = 0;
//            } else {
//                return digits;
//            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
