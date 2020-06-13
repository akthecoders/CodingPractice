//Island Perimeter
public class P463 {
    int dirs[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int[] land = findLand(grid);
        if (land[0] == -1) {
            return 0;
        }
        return calculatePerimeter(grid, land[0], land[1]);
    }

    public int calculatePerimeter(int[][] grid, int x, int y) {
        int validNeighbors = findValidNeighbours(grid, x, y);
        grid[x][y] = -1;
        for (int[] dir : dirs) {
            int r = dir[0] + x;
            int c = dir[1] + y;
            if (isInsideCanvas(grid, r, c)) {
                if (grid[r][c] == 1) {
                    validNeighbors += calculatePerimeter(grid, r, c);
                }
            }
        }
        return validNeighbors;
    }

    public int findValidNeighbours(int[][] grid, int x, int y) {
        int validNeighbors = 0;
        for (int[] dir : dirs) {
            int r = dir[0] + x;
            int c = dir[1] + y;

            if (isInsideCanvas(grid, r, c)) {
                if (grid[r][c] == 0) {
                    validNeighbors++;
                }
            } else {
                validNeighbors++;
            }
        }
        return validNeighbors;
    }

    public boolean isInsideCanvas(int[][] grid, int r, int c) {
        int m = grid.length;
        int n = grid[0].length;
        if (r >= 0 && r < m && c >= 0 && c < n) {
            return true;
        }
        return false;
    }

    public int[] findLand(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return new int[] { i, j };
            }
        }
        return new int[] { -1, -1 };
    }
}