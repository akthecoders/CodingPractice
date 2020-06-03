//Search a 2D Matrix
public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int row = -1;
        for (int i = 0; i < m; i++) {
            if (target <= matrix[i][n - 1]) {
                row = i;
                break;
            }
        }
        if (row == -1)
            return false;

        for (int i = 0; i < n; i++) {
            if (target == matrix[row][i]) {
                return true;
            }
        }
        return false;
    }
}