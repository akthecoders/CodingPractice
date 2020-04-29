// Minimum Falling Path Sum
public class P931 {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = A[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = A[i][j] + getMin(dp, i, j);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int r : dp[0]) {
            if (r < res) {
                res = r;
            }
        }

        return res;
    }

    public int getMin(int[][] mat, int i, int j) {
        int v1 = mat[i + 1][j];
        int v2 = Integer.MAX_VALUE;
        int v3 = Integer.MAX_VALUE;

        if (j + 1 < mat.length) {
            v2 = mat[i + 1][j + 1];
        }

        if (j - 1 >= 0) {
            v3 = mat[i + 1][j - 1];
        }

        return Math.min(v1, Math.min(v2, v3));
    }
}