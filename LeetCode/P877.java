// Stone Game
public class P877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int interval = 1; interval < n; interval++) {
            for (int l = 0; l < n - interval; l++) {
                int r = l + interval;
                int pickLeft = piles[l] - dp[l + 1][r];
                int pickRight = piles[r] - dp[l][r - 1];
                dp[l][r] = Math.max(pickLeft, pickRight);
            }
        }
        return dp[0][n - 1] > 0;
    }
}