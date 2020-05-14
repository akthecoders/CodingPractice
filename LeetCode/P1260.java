import java.util.ArrayList;
import java.util.List;

//Shift 2D Grid
public class P1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while (k > 0) {
            int temp = grid[grid.length - 1][grid[0].length - 1];
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if (j == 0) {
                        if (i > 0)
                            grid[i][j] = grid[i - 1][grid[0].length - 1];
                    } else {
                        grid[i][j] = grid[i][j - 1];
                    }
                }
            }
            grid[0][0] = temp;
            k--;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                t.add(grid[i][j]);
            }
            result.add(t);
        }
        return result;
    }
}