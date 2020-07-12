public class BooleanParathesization {
    public static void main(String[] args) {
        char[] input = {'T', '^', 'F', '&', 'T'};
        int dp[][][] = new int[input.length][input.length][2];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i > j) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }
                else if(i == j) {
                    dp[i][j][0] = input[i] == 'F' ? 1 : 0;
                    dp[i][j][1] = input[i] == 'T' ? 1 : 0;
                }
                else {
                    dp[i][j][0] = -1;
                    dp[i][j][1] = -1;
                }
            }
        }
        System.out.println(solve(input, 0, input.length - 1, true, dp));
    }

    public static int getInt(boolean isTrue) {
        if(isTrue) return 1;
        return 0;
    }
    public static int solve(char[] input, int i, int j, boolean isTrue, int [][][] dp) {
        if(dp[i][j][getInt(isTrue)] != -1) return dp[i][j][getInt(isTrue)];
        if(i > j ) return 0;
        if(i == j) {
            if(isTrue) {
                return input[i] == 'T' ? 1 : 0;
            }
            else {
                return input[i] == 'F' ? 1 : 0;
            }
        }

        int ans = 0;
        for(int k = i + 1; k <= j - 1; k += 2) {
            int lT = solve(input, i, k-1, true, dp);
            int lF = solve(input, i, k-1, false, dp);
            int rT = solve(input, k + 1, j, true, dp);
            int rF = solve(input, k + 1, j, false, dp);

            if(input[k] == '&') {
                if(isTrue) {
                    ans += (lT * rT);
                }
                else {
                    ans += ((lT * rF) + (lF * rF) + (lF * rT));
                }
            }
            else if(input[k] == '|') {
                if(isTrue) {
                    ans += ((lT * rF) + (lT * rT) + (lF * rT));
                }
                else {
                    ans += (lF * rF);
                }
            }
            else if(input[k] == '^') {
                if(isTrue) {
                    ans += ((lT * rF) + (lF * rT));
                }
                else {
                    ans += ((lF * rF) + (lT * rT));
                }
            }
            ans = ans%1003;
        }
        dp[i][j][getInt(isTrue)] = ans;
        return ans;
    }
}