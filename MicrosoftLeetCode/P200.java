//Number of Islands
public class P200 {
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        if (grid.length == 0)
            return 0;
        if (grid.length == 0 && grid[0].length == 0)
            return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    island++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        if (grid[x][y] == '0') {
            return;
        }

        for (int[] d : dir) {
            int nX = x + d[0];
            int nY = y + d[1];

            if (nX >= 0 && nX < grid.length && nY >= 0 && nY < grid[0].length) {
                dfs(grid, visited, nX, nY);
            }
        }

    }
}