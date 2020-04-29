// Minimum Cost Tree From Leaf Values
public class P1130 {
    class Result {
        int res;
        int multi;

        Result(int r, int m) {
            this.res = r;
            this.multi = m;
        }
    }

    Result[][] dp;

    public int mctFromLeafValues(int[] arr) {
        dp = new Result[arr.length][arr.length];
        return calculateNow(arr, 0, arr.length - 1).res;
    }

    public Result calculateNow(int[] arr, int start, int end) {
        if (dp[start][end] != null)
            return dp[start][end];

        if (start > end)
            return new Result(0, 1);

        if (start == end)
            return new Result(0, arr[start]);

        Result min = null;

        for (int i = start; i < end; i++) {
            Result a = calculateNow(arr, start, i);
            Result b = calculateNow(arr, i + 1, end);
            Result r = new Result((a.res + b.res + a.multi * b.multi), Math.max(a.multi, b.multi));
            if (min == null) {
                min = r;
            } else if (r.res < min.res) {
                min = r;
            }
        }

        dp[start][end] = min;
        return min;
    }
}