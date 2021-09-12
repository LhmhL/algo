package _3_day;

import java.util.Arrays;

public class _59_spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startRow = 0, endRow = n - 1;
        int startCol = 0, endCol = n - 1;
        int i = 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top 行
            for (int col = startCol; col <= endCol; col++)
                res[startRow][col] = i++;
            // right 列
            for (int row = startRow + 1; row <= endRow; row++)
                res[row][endCol] = i++;
            if (startRow < endRow && startCol < endCol) {
                // bottom 行
                for (int col = endCol - 1; col > startCol; col--)
                    res[endRow][col] = i++;
                // left 列
                for (int row = endRow; row > startRow; row--)
                    res[row][startCol] = i++;
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }
        return res;
    }

    public int[][] generateMatrix1(int n) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0;
        int col = 0;
        int di = 0;
        int[][] res = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        for (int i = 0; i < n * n; i++) {
            res[row][col] = i + 1;
            seen[row][col] = true;
            int nextRow = row + dirs[di][0];
            int nextCol = col + dirs[di][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n
                    || seen[nextRow][nextCol]) {
                di = (di + 1) % 4; // 改变方向
            }
            row = row + dirs[di][0];
            col = col + dirs[di][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new _59_spiral_matrix_ii().generateMatrix1(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
