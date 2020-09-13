import java.util.Arrays;

//Longest Increasing Path in a Matrix
public class P329 {
    static int dirs[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static int[][] memory;

    public int longestIncreasingPath(int[][] matrix) {
        // Base Cases
        if (matrix.length == 0)
            return 0;

        // Initializations
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        memory = new int[matrix.length][matrix[0].length];
        for (int v[] : memory) {
            Arrays.fill(v, -1);
        }
        for (boolean v[] : visited) {
            Arrays.fill(v, false);
        }
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j]) {
                    result = Math.max(result, dfs(matrix, visited, i, j));
                }
            }
        }
        return result;
    }

    // Helper Function
    public static int dfs(int[][] matrix, boolean[][] visited, int x, int y) {
        if (visited[x][y]) {
            return 0;
        }
        if (memory[x][y] != -1)
            return memory[x][y];
        visited[x][y] = true;
        int max = 0;
        for (int dir[] : dirs) {
            int tX = x + dir[0];
            int tY = y + dir[1];

            if (tX >= 0 && tY >= 0 && tX < matrix.length && tY < matrix[0].length) {
                if (!visited[tX][tY]) {
                    if (matrix[tX][tY] > matrix[x][y]) {
                        max = Math.max(max, dfs(matrix, visited, tX, tY));
                    }
                }
            }
        }
        visited[x][y] = false;
        memory[x][y] = max + 1;
        return 1 + max;

    }
}
