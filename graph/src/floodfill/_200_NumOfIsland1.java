package floodfill;

import java.util.LinkedList;
import java.util.Queue;

public class _200_NumOfIsland1 {
    private int rows;
    private int cols;
    private int[][] grid;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numOfIsland(int[][] grid) {
        if (grid == null) return 0;
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        if (cols == 0) return 0;
        this.grid = grid;
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{row, col});
                    grid[row][col] = 0;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.remove();
                        int currRow = curr[0];
                        int currCol = curr[1];
                        for (int[] dir : directions) {
                            int nextRow = currRow + dir[0];
                            int nextCol = currCol + dir[1];
                            if (inArea(nextRow, nextCol) && grid[nextRow][nextCol] == 1) {
                                queue.add(new int[]{nextRow, nextCol});
                                grid[nextRow][nextCol] = 0;
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    private boolean inArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,1,1,1,0,0,0},
                {0,1,0,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,1,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        _200_NumOfIsland1 maxAreaOfIsland = new _200_NumOfIsland1();
        System.out.println(maxAreaOfIsland.numOfIsland(grid));
    }
}
