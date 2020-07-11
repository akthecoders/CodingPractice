public class SequencePatternMatching {
    public static void main(String[] args) {
        String a = "AXY";
        String b = "ADXCPY";

        int [][] dp = new int[a.length() + 1][b.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        lcs(a, b, dp);

        System.out.println(dp[a.length()][b.length()] == a.length());
    }

    public static void lcs(String a, String b, int [][] dp ) {
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(a.charAt(i - 1) == b.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
    }
}