// Longest Common Subsequence
public class P1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n || j == m) {
                    dp[i][j] = 0;
                } else if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}