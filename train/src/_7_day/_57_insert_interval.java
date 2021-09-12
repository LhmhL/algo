package _7_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _57_insert_interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0; // 用于遍历所有的区间
        // 1. 将区间结束小于新区间开始的区间放入到结果集
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // 2. 将区间开始小于等于新区间结束的区间和新区间合并
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // 3. 将合并后的区间加入到结果集
        res.add(newInterval);
        // 4. 将剩余的区间放入到结果集
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] arrs = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] arr = new int[]{4,8};
        int[][] res = new _57_insert_interval().insert(arrs, arr);
        for (int[] tmp:res) {
            System.out.println(Arrays.toString(tmp));
        }
    }
}
