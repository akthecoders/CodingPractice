public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str1 = "abceabcd";
        String str2 = "abceabcd";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) {dp[i][j] = 0;}
            }
        }

        lcs(str1, str2, dp);
        System.out.println(dp[str1.length()][str2.length()]);
    }

    public static void lcs(String str1, String str2, int[][] dp) {
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j-1) && i != j) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }
}