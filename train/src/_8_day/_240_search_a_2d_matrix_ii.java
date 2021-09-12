package _8_day;

public class _240_search_a_2d_matrix_ii {
    // 暴力解法
    // 时间复杂度 O(mn)
    // 空间复杂度 O(1)
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 二分查找
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int shortDim = Math.min(m, n);
        for (int i = 0; i < shortDim; i++) {
            boolean rowFound = binarySearchRow(matrix, i, target);
            boolean colFound = binarySearchCol(matrix, i, target);
            if (rowFound || colFound) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearchRow(int[][] matrix, int row, int target) {
        int lo = row;
        int hi = matrix[0].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    private boolean binarySearchCol(int[][] matrix, int col, int target) {
        int lo = col;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][col] == target) {
                return true;
            } else if (matrix[mid][col] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }

    // 缩减搜索空间
    public boolean searchMatrix00(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) j++;
            else if (matrix[i][j] > target) i--;
            else return true;
        }
        return false;
    }

    // 缩减搜索空间
    public boolean searchMatrix01(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target) i++;
            else if (matrix[i][j] > target) j--;
            else return true;
        }
        return false;
    }
}
