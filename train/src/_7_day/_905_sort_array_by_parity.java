package _7_day;

import java.util.Arrays;

public class _905_sort_array_by_parity {
    // 快排分区的逻辑优化
    // 对撞指针
    public int[] sortArrayByParity(int[] A) {
        int less = 0, great = A.length - 1;
//        while (less < great) {
//            if (A[less] % 2 == 0) {
//                less++;
//            } else if (A[great] % 2 == 0) {
//                int tmp = A[less];
//                A[less] = A[great];
//                A[great] = tmp;
//                less++;
//                great--;
//            } else {
//                great--;
//            }
//        }
        while (less < great) {
            if (A[less] % 2 == 0) {
                less++;
            } else {
                int tmp = A[less];
                A[less] = A[great];
                A[great] = tmp;
                great--;
            }
        }
        return A;
    }

    // 快排分区的逻辑
    // 快慢指针
    public int[] sortArrayByParity4(int[] A) {
        int less = 0, great = 0;
        for (; great < A.length ; great++) {
            if (A[less] % 2 == 0) {
                less++;
            } else if (A[great] % 2 == 0) {
                int tmp = A[less];
                A[less] = A[great];
                A[great] = tmp;
                less++;
            }
        }
        return A;
    }

    public int[] sortArrayByParity3(int[] A) {
        int n = A.length;
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) tmp[i] = A[i];
        Arrays.sort(tmp, (o1, o2) -> o1 % 2 - o2 % 2);
        for (int i = 0; i < n; i++) A[i] = tmp[i];
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[left] = A[i];
                left++;
            } else {
                res[right] = A[i];
                right--;
            }
        }
        return res;
    }

    public int[] sortArrayByParity1(int[] A) {
        int[] res = new int[A.length];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                res[count] = A[i];
                count++;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                res[count] = A[i];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new _905_sort_array_by_parity().sortArrayByParity(new int[]{3,1,2,4});
        System.out.println(Arrays.toString(res));
    }
}
