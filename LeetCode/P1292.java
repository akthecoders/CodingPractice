//Maximum Side Length of a Square with Sum Less than or Equal to Threshold
public class P1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int res = 0, l = 0;
        int row = mat.length, col = mat[0].length;
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 1; i <= mat.length; i++) {
            for (int j = 1; j <= mat[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                while (i + l <= row && j + l <= col
                        && dp[i + l][j + l] - dp[i][j + l] - dp[i + l][j] + dp[i][j] <= threshold) {
                    res = l;
                    l++;
                }
            }
        }
        return res;
    }
}