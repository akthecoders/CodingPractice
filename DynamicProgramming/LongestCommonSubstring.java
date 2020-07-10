public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ababcde";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) {dp[i][j] = 0;}
            }
        }
        int longest = getCommonBottomUp(str1, str2, dp);
        System.out.println(longest);
    }

    public static int getCommonBottomUp(String str1, String str2, int[][] dp) {
        int longest = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    longest = Math.max(longest, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return longest;
    }
}