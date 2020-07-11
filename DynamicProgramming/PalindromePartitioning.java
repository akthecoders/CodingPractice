public class PalindromePartitioning {
    public static void main(String[] args) {
        String input = "ababbbabbababa";
        int dp[][] = new int[input.length() + 1][input.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(solve(input, 0, input.length() - 1));
        System.out.println(topDown(input, 0, input.length() - 1, dp));
    }

    public static int solve(String input, int start, int end) {
        if(start >= end) return 0;
        if(isPalindrome(input, start, end)) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for(int k = start; k <= end - 1; k++) {
            result = Math.min(result, 1 + solve(input, start, k) + solve(input, k + 1, end));
        }
        return result;
    }

    public static boolean isPalindrome(String input, int start, int end ) {
        if(start > end) return false;

        while(start < end) {
            if(input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static int topDown(String input, int start, int end, int[][] dp) {
        if(dp[start][end] != -1) return dp[start][end];

        if(start >= end) return 0;
        if(isPalindrome(input, start, end)) {
            dp[start][end] = 0;
            return 0;
        }

        int result = Integer.MAX_VALUE;
        for(int k = start; k <= end - 1; k++) {
            result = Math.min(result, 1 + solve(input, start, k) + solve(input, k + 1, end));
        }
        dp[start][end] = result;
        return result;
    }
}