package algo.sort.train;

import java.util.Arrays;
import java.util.Comparator;

public class _252_MeetingRooms {
    public Boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            int currIntervalRight = intervals[i][1];
            int nextIntervalLeft = intervals[i + 1][0];
            if (currIntervalRight > nextIntervalLeft) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,30},{5,10},{15,20}};
        Boolean res = new _252_MeetingRooms().canAttendMeetings(arr);
        System.out.println(res);
        arr = new int[][]{{7,10},{2,4}};
        res = new _252_MeetingRooms().canAttendMeetings(arr);
        System.out.println(res);
    }
}
