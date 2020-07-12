import java.util.Arrays;

public class EggDroppingProblem {
    public static void main(String[] args) {
        int e = 2;
        int f = 10;
        int [][] dp = new int[10001][1001];
        for(int[] x: dp) {
            Arrays.fill(x, -1);
        }
        System.out.println(solve(e, f, dp));

    }

    public static int solve(int e, int f, int[][] dp) {
        if(f == 0 || f == 1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];
        int min  = Integer.MAX_VALUE;
        for(int i = 1; i <= f; i++) {
            int t = Math.max(solve(e - 1, i - 1, dp), solve(e , f - i, dp));
            min = Math.min(min, t);
        }
        dp[e][f] = min + 1;
        return min + 1;
    }
}