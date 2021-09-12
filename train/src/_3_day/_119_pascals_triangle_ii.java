package _3_day;

import java.util.ArrayList;
import java.util.List;

public class _119_pascals_triangle_ii {
    // 只用一个数组
    // 空间复杂度：O(k)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> oneRow = new ArrayList<>();
        oneRow.add(1);
        for (int row = 1; row <= rowIndex; row++) {
            oneRow.add(0); // java
            for (int col = row; col > 0; col--) {
                oneRow.set(col, oneRow.get(col - 1) + oneRow.get(col));
            }
        }
        return oneRow;
    }

    // 空间复杂度：O(k^2)
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> preRow = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            List<Integer> oneRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    oneRow.add(1);
                } else {
                    oneRow.add(preRow.get(col - 1) + preRow.get(col));
                }
            }
            preRow = oneRow;
        }
        return preRow;
    }

    // 空间复杂度：O(k^2)
    public List<Integer> getRow1(int rowIndex) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            List<Integer> oneRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    oneRow.add(1);
                } else {
                    List<Integer> preRow = rows.get(row - 1);
                    oneRow.add(preRow.get(col - 1) + preRow.get(col));
                }
            }
            rows.add(oneRow);
        }
        return rows.get(rowIndex);
    }

    public static void main(String[] args) {
        List<Integer> res = new _119_pascals_triangle_ii().getRow(5);
        System.out.println(res);
    }
}
