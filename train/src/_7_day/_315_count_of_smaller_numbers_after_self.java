package _7_day;

import java.util.ArrayList;
import java.util.List;

public class _315_count_of_smaller_numbers_after_self {
    private int[] indexes;
    private int[] tmpIndexes;
    private int[] res;

    public List<Integer> countSmaller(int[] nums) {
        // 记录原始数组每个元素的索引信息，方便在合并的时候知道是计算哪一个元素
        this.indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) indexes[i] = i;
        this.tmpIndexes = new int[nums.length];
        this.res = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        List<Integer> list = new ArrayList<>();
        for (int num : res) {
            list.add(num);
        }
        return list;
    }

    private void mergeSort(int[] nums, int lo, int hi, int[] tmp) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid, tmp);
        mergeSort(nums, mid + 1, hi, tmp);
        merge(nums, lo, mid, hi, tmp);
    }

    private void merge(int[] nums, int lo, int mid, int hi, int[] tmp) {
        for (int i = lo; i <= hi; i++) {
            tmp[i] = nums[i];
            tmpIndexes[i] = indexes[i];
        }
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i == mid + 1) {
                nums[k] = tmp[j];
                indexes[k] = tmpIndexes[j];
                j++;
            }
            else if (j == hi + 1) {
                nums[k] = tmp[i];
                indexes[k] = tmpIndexes[i];
                // 计算比当前元素小的后面元素的个数
                res[tmpIndexes[i]] += (j - mid - 1);
                i++;
            }
            else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i];
                indexes[k] = tmpIndexes[i];
                // 计算比当前元素小的后面元素的个数
                res[tmpIndexes[i]] += (j - mid - 1);
                i++;
            }
            else {
                nums[k] = tmp[j];
                indexes[k] = tmpIndexes[j];
                j++;
            }
        }
    }
}
