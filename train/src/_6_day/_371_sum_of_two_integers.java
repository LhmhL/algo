package _6_day;

public class _371_sum_of_two_integers {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // 进位
            a = a ^ b; // 二进制无进位加法
            b = carry;
        }
        return a;
    }
}
