package _8_day;

public class _74_search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = matrix[mid / n][mid % n];
            if (num == target) return true;
            else if (num < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == target) return true;
            }
        }
        return false;
    }
}
