package _5_day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _989_add_to_array_form_integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int l1 = A.length - 1;
        while (l1 >= 0 || K != 0) {
            int x = l1 < 0 ? 0 : A[l1];
            int y = K == 0 ? 0 : K % 10;
            int sum = x + y + carry;
            res.add(sum % 10);
            carry = sum / 10;
            l1--;
            K = K / 10;
        }
        if (carry != 0) res.add(carry);
        Collections.reverse(res);
        return res;
    }
}
