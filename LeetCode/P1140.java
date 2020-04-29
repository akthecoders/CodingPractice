// Stone Game II
public class P1140 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] sums = new int[n];
        sums[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sums[i] += sums[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n / 2; m++) {
                for (int x = 1; x <= 2 * m && i + x <= n; x++)
                    if (i + x == n)
                        dp[i][m] = Math.max(dp[i][m], sums[i]);
                    else
                        dp[i][m] = Math.max(dp[i][m], sums[i] - dp[i + x][Math.max(m, x)]);
            }
        }

        return dp[0][1];
    }
}