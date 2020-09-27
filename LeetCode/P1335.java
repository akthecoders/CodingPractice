//Minimum Difficulty of a Job Schedule
public class P1335 {
    Long dp[][];

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n)
            return -1;
        dp = new Long[n][d + 1];
        return (int) solve(0, d, jobDifficulty);
    }

    public long solve(int idx, int d, int a[]) {
        if (idx == a.length && d == 0)
            return 0;
        if (d == 0)
            return Integer.MAX_VALUE;
        if (dp[idx][d] != null)
            return dp[idx][d];
        long min = Integer.MAX_VALUE;
        long max_in_particular_cut = Integer.MIN_VALUE;
        for (int j = idx; j + d <= a.length; j++) {
            // cut range => idx to j
            max_in_particular_cut = Math.max(max_in_particular_cut, a[j]);
            // next cut from j+1 onwards
            min = Math.min(min, max_in_particular_cut + solve(j + 1, d - 1, a));
        }
        return dp[idx][d] = min;
    }
}
