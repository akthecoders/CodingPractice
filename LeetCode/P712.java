// Minimum ASCII Delete Sum for Two Strings
public class P712 {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0)
            return 0;
        if (s1.length() == 0)
            return sum(s1);
        if (s2.length() == 0)
            return sum(s2);
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp[0].length; i++)
            dp[0][i] = dp[0][i - 1] + s2.charAt(i - 1);
        for (int i = 1; i < dp.length; i++)
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);

        for (int i = 1; i < dp.length; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j < dp[0].length; j++) {
                char c2 = s2.charAt(j - 1);
                if (c1 == c2)
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c2);
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public int sum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (s.charAt(i));
        }
        return res;
    }
}