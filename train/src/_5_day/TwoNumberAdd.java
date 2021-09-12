package _5_day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoNumberAdd {
    public List<Integer> addTwoNum(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int l1 = nums1.length - 1;
        int l2 = nums2.length - 1;
        while (l1 >= 0 || l2 >= 0) {
            int x = l1 < 0 ? 0 : nums1[l1];
            int y = l2 < 0 ? 0 : nums2[l2];
            int sum = x + y + carry;
            res.add(sum % 10);
            carry = sum / 10;
            l1--;
            l2--;
        }
        if (carry != 0) res.add(carry);
        Collections.reverse(res);
        return res;
    }

    public List<Integer> addTwoNum(int nums1, int nums2) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        while (nums1 != 0 || nums2 != 0) {
            int x = nums1 == 0 ? 0 : nums1 % 10;
            int y = nums2 == 0 ? 0 : nums2 % 10;
            int sum = x + y + carry;
            res.add(sum % 10);
            carry = sum / 10;
            nums1 = nums1 / 10;
            nums2 = nums2 / 10;
        }
        if (carry != 0) res.add(carry);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new TwoNumberAdd().addTwoNum(999, 1);
        System.out.println(res);
        res = new TwoNumberAdd().addTwoNum(new int[]{9,9,9}, new int[]{1});
        System.out.println(res);
    }
}
