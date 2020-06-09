//Ugly Number II
public class P264 {
    public int nthUglyNumber(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int p1 = 2;
        int i1 = 0;

        int p3 = 3;
        int i3 = 0;

        int p5 = 5;
        int i5 = 0;

        int dp[] = new int[n + 1];
        dp[0] = 1;
        int curr = 1;

        while (curr <= n) {
            if (p1 < p3) {
                if (p1 < p5) {
                    dp[curr++] = p1;
                    i1++;
                    p1 = 2 * dp[i1];
                } else {
                    dp[curr++] = p5;
                    i5++;
                    p1 = 5 * dp[i5];
                }
            } else if (p1 < p5) {
                dp[curr++] = p1;
                i1++;
                p1 = 2 * dp[i1];
            } else if (p3 < p5) {
                dp[curr++] = p3;
                i3++;
                p3 = 3 * dp[i3];
            } else {
                dp[curr++] = p5;
                i5++;
                p5 = 5 * dp[i5];
            }
        }
        return dp[n];
    }
}