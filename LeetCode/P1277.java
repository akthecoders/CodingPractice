// Count Square Submatrices with All Ones
public class P1277 {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    int top = matrix[i - 1][j];
                    int left = matrix[i][j - 1];
                    int topLeft = matrix[i - 1][j - 1];
                    int min = Math.min(left, Math.min(top, topLeft));

                    matrix[i][j] = min + 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += matrix[i][j];
            }
        }

        return ans;
    }
}