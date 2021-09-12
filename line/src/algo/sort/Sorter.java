package algo.sort;

public class Sorter {
    public <E> void swap(E[] nums, int i, int j) {
        E tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
