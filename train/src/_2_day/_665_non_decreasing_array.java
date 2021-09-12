package _2_day;

public class _665_non_decreasing_array {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                cnt++;
                if (cnt > 1) return false;
                if (i - 2 >= 0 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{4,5,3,5};
        int[] arr = new int[]{4,6,5,5};
        boolean res = new _665_non_decreasing_array().checkPossibility(arr);
        System.out.println(res);
    }
}
