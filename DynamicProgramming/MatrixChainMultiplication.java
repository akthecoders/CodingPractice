public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int [] input = {10,20,30,40};
        int dp[][] = new int[input.length + 1][input.length  + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(input, 1, input.length - 1));
        System.out.println(topDown(input, 1, input.length - 1, dp));
    }

    public static int solve(int[] input, int i, int j) {
        if(i >= j ) return 0;

        int result = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            result = Math.min(result, (solve(input, i, k) + solve(input, k + 1, j) + input[i] * input[k] * input[j]));
        }
        return result;
    }

    public static int topDown(int[] input, int i, int j, int[][] dp) {
        if(dp[i][j] != -1 ) return dp[i][j];

        if(i >= j ) return 0;

        int result = Integer.MAX_VALUE;
        for(int k = i; k <= j - 1; k++) {
            result = Math.min(result, (solve(input, i, k) + solve(input, k + 1, j) + input[i] * input[k] * input[j]));
        }
        dp[i][j] = result;
        return result;
    }
}