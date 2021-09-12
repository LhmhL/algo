package _2_day;

public class _941_valid_mountain_array {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // 1. 找到最高点
        while (i < n - 1 && arr[i] < arr[i + 1]) i++;

        // 2. 判断：最高点不能是第一个和最后一个元素
        if (i == 0 || i == n - 1) return false;

        // 3. 从最高点往后递减扫描
        while (i < n - 1 && arr[i] > arr[i + 1]) i++;

        // 4. 如果 i 指向数组最后一个元素，则返回 true，否则返回 false
        return i == n - 1;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{0,3,7,8,6,5,2,1};
        int[] arr = new int[]{1,2,3,5,5,4,1};
        boolean res = new _941_valid_mountain_array().validMountainArray(arr);
        System.out.println(res);
    }
}
