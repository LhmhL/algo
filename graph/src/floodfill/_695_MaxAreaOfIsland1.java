package floodfill;

public class _695_MaxAreaOfIsland1 {
    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;
        if (cols == 0) return 0;
        this.grid = grid;
        this.visited = new boolean[rows][cols];
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {
                    res = Math.max(dfs(row, col), res);
                }
            }
        }
        return res;
    }

    private int dfs(int row, int col) {
        visited[row][col] = true;
        int res = 1;
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (inArea(nextRow, nextCol) && !visited[nextRow][nextCol] && grid[nextRow][nextCol] == 1) {
                res += dfs(nextRow, nextCol);
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
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
        };
        _695_MaxAreaOfIsland1 maxAreaOfIsland = new _695_MaxAreaOfIsland1();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(grid));
    }
}
