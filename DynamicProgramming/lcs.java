public class lcs {
    public static void main(String[] args) {
        String str1 = "abcdefghl";
        String str2 = "abczertl";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) {dp[i][j] = 0;}
            }
        }

        getCommonBottomUp(str1, str2, dp);
        System.out.println(dp[str1.length()][str2.length()]);

        
        System.out.println(getCommonRecursive(str1, str2));
    }

    public static void getCommonBottomUp(String str1, String str2, int[][] dp) {
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
    }

    public static int getCommonRecursive(String str1, String str2) {
        if(str1.length() == 0 || str2.length() == 0) return 0;

        if(str1.charAt(str1.length() - 1) == str2.charAt(str2.length() - 1)) {
            return 1 + getCommonRecursive(str1.substring(0, str1.length() - 1), str2.substring(0, str2.length() - 1));
        }
        else {
            return Math.max(getCommonRecursive(str1, str2.substring(0, str2.length() - 1)), getCommonRecursive(str1.substring(0, str1.length() - 1), str2));
        }
    }
}