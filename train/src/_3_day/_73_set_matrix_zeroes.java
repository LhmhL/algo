package _3_day;

import java.util.Arrays;

public class _73_set_matrix_zeroes {
    // 时间复杂度 O(mn)
    // 空间复杂度 O(1)
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 先计算第一列是否包含 0
        boolean flagCol1 = false;
        // 使用 matrix 的第一行和第一列来记录每行每列是否包含 0
        for (int row = 0; row < m; row++) {
            // 计算第一列是否包含 0
            if (matrix[row][0] == 0) flagCol1 = true;
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = m - 1; row >= 0; row--) {
            for (int col = 1; col < n; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
            if (flagCol1) {
                matrix[row][0] = 0;
            }
        }
    }

    // 时间复杂度 O(mn)
    // 空间复杂度 O(1)
    public void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 先计算第一行第一列是否包含 0
        boolean flagRow1 = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) flagRow1 = true;
        }
        boolean flagCol1 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) flagCol1 = true;
        }
        // 使用 matrix 的第一行和第一列来记录每行每列是否包含 0
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (flagRow1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // 时间复杂度 O(mn)
    // 空间复杂度 O(m + n)
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录每行或者每列是否包含 0
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
                if (rows[row] || cols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    // 时间复杂度 O(mn)
    // 空间复杂度 O(m + n)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 记录每行或者每列是否包含 0
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 0) {
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rows[row] || cols[col]) {
                    matrix[row][col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new _73_set_matrix_zeroes().setZeroes2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
