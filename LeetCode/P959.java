public class P959 {
    public static void main(String[] args) {
        P959 run = new P959();
        String[] input = {"/\\","\\/"};

        System.out.println(run.regionsBySlashes(input));
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int[][] matGrid = new int[N * 3][N * 3];
        
        for(int i = 0; i < N; i++) {
            fillGrid(i, grid[i], matGrid);
        }
        return findRegions(matGrid);
    }
    
    public int findRegions(int[][] matGrid) {
        boolean visited[][] = new boolean[matGrid.length][matGrid.length];
        for(int i = 0; i < matGrid.length; i++) {
            for(int j = 0; j < matGrid.length; j++) {
                visited[i][j] = false;
            }
        }
        int result = 0;
        for(int i = 0; i < matGrid.length; i++) {
            for(int j = 0; j < matGrid.length; j++) {
                if(!visited[i][j] && matGrid[i][j] != 1) {
                    result++;
                    exploreMatrix(matGrid, visited, i, j);
                }
            }
        }
        return result;
    }

    public void exploreMatrix(int[][] matrix, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        if(matrix[x][y] == 1) {
            return;
        }

        int N = matrix.length;
        if(isValidPos(x - 1, y, N, visited)) {
            exploreMatrix(matrix, visited, x - 1, y);
        }
        if(isValidPos(x, y + 1, N, visited)) {
            exploreMatrix(matrix, visited, x, y + 1);
        }
        if(isValidPos(x + 1, y, N, visited)) {
            exploreMatrix(matrix, visited, x + 1, y);
        }
        if(isValidPos(x, y -1, N, visited)) {
            exploreMatrix(matrix, visited, x, y - 1);
        }
        return;
    }

    public boolean isValidPos(int x, int y, int N, boolean[][] visited) {
        if((x >= 0 && y >= 0) && (x < N && y < N) && !visited[x][y]) {
            return true;
        }
        return false;
    }

    public void fillGrid(int gridId, String gridInput, int[][] matGrid) {
        for(int i = 0; i < gridInput.length(); i++) {
            if(gridInput.charAt(i) == '/') {
                markGrid(matGrid, i, gridId, false);
            }
            else if(gridInput.charAt(i) == '\\') {
                markGrid(matGrid, i, gridId, true);
            }
        }
    }
    
    public void markGrid(int[][] matGrid, int gridX, int gridY, boolean ltr) {
        int row = gridY * 3;
        int col = gridX * 3;
        
        int rowEnd = row + 3;
        int colEnd = col + 3;
        
        if(ltr) {
            for(int i = row, j = col; i < rowEnd || j < colEnd; i++, j++) {
                matGrid[i][j] = 1;
            }
        }
        else {
            for(int i = row, j = colEnd - 1; i < rowEnd || j >= col; i++, j--) {
                matGrid[i][j] = 1;
            }
        }
    }
}