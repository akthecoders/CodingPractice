public class RodCutting {
    public static void main(String[] args) {
        int prices[] = {10, 40, 50, 70};
        int length[] = {1, 3, 4, 5};
        int n = 8;

        int dp[][] = new int[length.length + 1][n+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(j == 0) dp[i][j] = 0;
                if(i == 0) dp[i][j] = 0;
            }
        }

        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(length[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], prices[i-1] + dp[i][j - length[i-1]]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println("MAx Profigt : " + dp[length.length][n]);
    }
}