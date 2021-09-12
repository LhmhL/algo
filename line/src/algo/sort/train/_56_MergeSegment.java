package algo.sort.train;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class _56_MergeSegment {
    public int[][] merge(int[][] intervals) {
        // 1. 按照区间左边的值进行升序排列
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 2. 初始化 outputs, 用于存储合并之后区间结果的动态数组
        ArrayList<int[]> outputs = new ArrayList<>();
        // 3. 遍历处理每一个区间
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (outputs.isEmpty()) {
                outputs.add(currInterval);
            } else { // 判断是否有重叠，有的话则合并
                int[] outputsLastInterval = outputs.get(outputs.size() - 1);
                int outputLastRight = outputsLastInterval[1];
                int currLeft = currInterval[0];
                if (outputLastRight < currLeft) { // 没有重叠
                    outputs.add(currInterval);
                } else { // 有重叠，合并
                    int currRight = currInterval[1];
                    outputsLastInterval[1] = Math.max(outputLastRight, currRight);
                }
            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,6},{1,3},{15,18},{8,10},{12,20}};
        for (int[] tmp : arr) {
            System.out.println(Arrays.toString(tmp));
        }
        int[][] arrMerge = new _56_MergeSegment().merge(arr);
        for (int[] tmp : arrMerge) {
            System.out.println(Arrays.toString(tmp));
        }
    }
}
