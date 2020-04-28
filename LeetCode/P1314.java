//  Matrix Block Sum
public class P1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int sum[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int[][] res = new int[m][n];
        int i1, i2, j1, j2;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                i1 = Math.max(1, i - K);
                i2 = Math.min(m, i + K);
                j1 = Math.max(1, j - K);
                j2 = Math.min(n, j + K);

                res[i - 1][j - 1] = sum[i2][j2] - sum[i1 - 1][j2] - sum[i2][j1 - 1] + sum[i1 - 1][j1 - 1];
            }
        }

        return res;

    }
}