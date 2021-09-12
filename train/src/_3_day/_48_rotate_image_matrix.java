package _3_day;

import java.util.Arrays;

public class _48_rotate_image_matrix {
    // 原地翻转
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int row = 0; row < n / 2; row++) {
            for (int col = 0; col < n; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - row - 1][col];
                matrix[n - row - 1][col] = tmp;
            }
        }
        // 主对角线翻转
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < row; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
    }

    // 原地旋转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n / 2; row++) {
            for (int col = 0; col < (n + 1) / 2; col++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[n - col - 1][row];
                matrix[n - col - 1][row] = matrix[n - row - 1][n - col - 1];
                matrix[n - row - 1][n - col - 1] = matrix[col][n - row - 1];
                matrix[col][n - row - 1] = tmp;
            }
        }
    }

    // 使用额外数组
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                newMatrix[col][n - row - 1] = matrix[row][col];
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = newMatrix[row][col];
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        new _48_rotate_image_matrix().rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
