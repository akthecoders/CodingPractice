/**
 * P1246
 * Palindrome Removal
 */
public class P1246 {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) dp[i][j] = 1;
                else if (i+1 == j) {
                    dp[i][j] = arr[i] == arr[j] ? 1 : 2; 
                } else {
                    int cand1 = n, cand2 = n, cand3 = n;
                    if (arr[i] == arr[j]) {
                        cand1 = dp[i+1][j-1];
                    }
                    cand2 = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
                    for (int k = i+1; k < j-1; k++) {
                        cand3 = Math.min(cand3, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = Math.min(cand1, Math.min(cand2, cand3));
                }
            }
        }
        return dp[0][n-1];
    }
}