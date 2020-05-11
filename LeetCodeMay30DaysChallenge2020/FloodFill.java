import java.util.Arrays;

public class FloodFill {
    boolean[][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int col = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        for (boolean[] x : visited) {
            Arrays.fill(x, false);
        }
        helper(image, sr, sc, newColor, col);
        return image;
    }

    public void helper(int[][] image, int x, int y, int newColor, int colToErase) {
        if (!isValid(image, x, y, colToErase))
            return;
        image[x][y] = newColor;
        visited[x][y] = true;
        helper(image, x - 1, y, newColor, colToErase);
        helper(image, x, y - 1, newColor, colToErase);
        helper(image, x, y + 1, newColor, colToErase);
        helper(image, x + 1, y, newColor, colToErase);
    }

    public boolean isValid(int[][] image, int x, int y, int colToErase) {
        int r = image.length; // y
        int c = image[0].length; // x
        if (x >= 0 && x < r && y >= 0 && y < c && image[x][y] == colToErase && visited[x][y] == false) {
            return true;
        }
        return false;
    }
}