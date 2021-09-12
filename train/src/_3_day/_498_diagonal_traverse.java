package _3_day;

import java.util.Arrays;

public class _498_diagonal_traverse {
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = 0;
        int di = 0;
        int[] result = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            if (di % 2 == 0) {
                row = row - 1;
                col = col + 1;
            } else {
                row = row + 1;
                col = col - 1;
            }
            if (col >= n) {
                col = n - 1; row += 2; di++;
            }
            if (row >= m) {
                row = m - 1; col += 2; di++;
            }
            if (row < 0) {
                row = 0; di++;
            }
            if (col < 0) {
                col = 0; di++;
            }
        }
        return result;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{-1, 1}, {1, -1}};
        int row = 0;
        int col = 0;
        int di = 0;
        int[] result = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[row][col];
            row = row + dirs[di][0];
            col = col + dirs[di][1];
            if (col >= n) {
                col = n - 1; row += 2; di = 1 - di;
            }
            if (row >= m) {
                row = m - 1; col += 2; di = 1 - di;
            }
            if (row < 0) {
                row = 0; di = 1 - di;
            }
            if (col < 0) {
                col = 0; di = 1 - di;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] res = new _498_diagonal_traverse().findDiagonalOrder(arr);
        System.out.println(Arrays.toString(res));
    }
}
