//Path with Maximum Gold
public class P1219 {
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dfs(grid, visited, i, j, 0);
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int[][] visited, int i, int j, int v) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0)
            return;
        visited[i][j] = 1;
        v += grid[i][j];
        max = Math.max(max, v);
        dfs(grid, visited, i + 1, j, v);
        dfs(grid, visited, i - 1, j, v);
        dfs(grid, visited, i, j + 1, v);
        dfs(grid, visited, i, j - 1, v);
        visited[i][j] = 0;
    }
}