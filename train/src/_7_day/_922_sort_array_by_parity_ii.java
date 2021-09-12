package _7_day;

import java.util.Arrays;

public class _922_sort_array_by_parity_ii {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int i = 0, j = 1;
//        while (i < n) {
//            if (A[i] % 2 == 0) {
//                i += 2;
//            } else {
//                int temp = A[i];
//                A[i] = A[j];
//                A[j] = temp;
//                j += 2;
//            }
//        }
        while (i < n) {
            if (A[i] % 2 == 0) {
                i += 2;
            } else if (A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i += 2;
                j += 2;
            } else {
                j += 2;
            }
        }
        return A;
    }

    public int[] sortArrayByParityII1(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int i = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                res[i] = a;
                i += 2;
            }
        }
        i = 1;
        for (int a : A) {
            if (a % 2 == 1) {
                res[i] = a;
                i += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new _922_sort_array_by_parity_ii().sortArrayByParityII(new int[]{3,1,2,4});
        System.out.println(Arrays.toString(res));
    }
}
