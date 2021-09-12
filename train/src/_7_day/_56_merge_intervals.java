package _7_day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_merge_intervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> outputs = new ArrayList<>();
        outputs.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = outputs.get(outputs.size() - 1);
            int currLeft = intervals[i][0];
            int currRight = intervals[i][1];
            if (lastInterval[1] < currLeft) {
                outputs.add(intervals[i]);
            } else {
                lastInterval[1] = Math.max(lastInterval[1], currRight);
            }
        }
        return outputs.toArray(new int[outputs.size()][]);
    }
}
