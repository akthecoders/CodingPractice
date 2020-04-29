// Minimum Cost For Tickets
import java.util.*;
public class P983 {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int dp[] = new int[n + 1];
        boolean travel[] = new boolean[n + 1];
        Arrays.fill(travel, false);
        for (int i = 0; i < days.length; i++) {
            travel[days[i]] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            if (travel[i]) {
                int one = dp[i - 1] + costs[0];
                int seven = dp[Math.max(i - 7, 0)] + costs[1];
                int thirty = dp[Math.max(i - 30, 0)] + costs[2];

                dp[i] = (int) Math.min(one, (int) Math.min(seven, thirty));
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n];
    }
}