//Search a 2D Matrix
public class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int row = -1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == target) {
                return true;
            } else if (matrix[i][n - 1] > target) {
                row = i;
                break;
            }
        }

        if (row == -1)
            return false;
        return findInRow(row, matrix, n, target);

    }

    public boolean findInRow(int row, int[][] matrix, int n, int target) {
        for (int i = 0; i < n - 1; i++) {
            if (matrix[row][i] == target) {
                return true;
            }
        }
        return false;
    }
}