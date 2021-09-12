package _10_day;

import java.util.ArrayDeque;
import java.util.Arrays;

public class _85_maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    left[row][col] = (col == 0 ? 0 : left[row][col - 1]) + 1;
                }
            }
        }
        int res = 0;
        for (int col = 0; col < n; col++) {
            int[] up = new int[m];
            int[] down = new int[m];
            Arrays.fill(down, m);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int row = 0; row < m; row++) {
                while (!stack.isEmpty() && left[row][col] <= left[stack.peek()][col]) {
                    down[stack.peek()] = row;
                    stack.pop();
                }
                up[row] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(row);
            }
            for (int row = 0; row < m; row++) {
                int height = left[row][col];
                int width = down[row] - up[row] - 1;
                res = Math.max(res, height * width);
            }
        }
        return res;
    }

    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] up = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    up[row][col] = (row == 0 ? 0 : up[row - 1][col]) + 1;
                }
            }
        }
        int res = 0;
        for (int row = 0; row < m; row++) {
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int col = 0; col < n; col++) {
                while (!stack.isEmpty() && up[row][col] <= up[row][stack.peek()]) {
                    right[stack.peek()] = col;
                    stack.pop();
                }
                left[col] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(col);
            }
            for (int col = 0; col < n; col++) {
                int height = up[row][col];
                int width = right[col] - left[col] - 1;
                res = Math.max(res, height * width);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] nums = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
                };
        int res = new _85_maximal_rectangle().maximalRectangle(nums);
        System.out.println(res);
    }
}
