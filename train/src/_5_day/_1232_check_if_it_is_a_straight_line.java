package _5_day;

public class _1232_check_if_it_is_a_straight_line {
    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int deltaY = coordinates[1][1] - y0;
        int deltaX = coordinates[1][0] - x0;
        for (int i = 2; i < coordinates.length; i++) {
            int deltaYi = coordinates[i][1] - y0;
            int deltaXi = coordinates[i][0] - x0;
            if (deltaY * deltaXi != deltaYi * deltaX)
                return false;
        }
        return true;
    }
}
