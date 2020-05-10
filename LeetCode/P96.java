import java.util.Arrays;

//Unique Binary Search Trees

public class P96 {
    public int numTrees(int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public int helper(int n, int[] dp) {
        if (n == 1 || n == 0)
            return 1;
        int comb = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == -1) {
                dp[i] = helper(i, dp);
            }
            if (dp[n - 1 - i] == -1) {
                dp[n - 1 - i] = helper(n - 1 - i, dp);
            }
            comb += dp[i] * dp[n - i - 1];
        }
        return comb;
    }
}