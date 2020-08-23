//Longest Palindromic Subsequence
public class P516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length() + 1;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                char A = s.charAt(i - 1);
                char B = s.charAt(n - j - 1);
                if (A == B) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}