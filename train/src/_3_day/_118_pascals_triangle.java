package _3_day;

import java.util.ArrayList;
import java.util.List;

public class _118_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
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
        return rows;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new _118_pascals_triangle().generate(5);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
