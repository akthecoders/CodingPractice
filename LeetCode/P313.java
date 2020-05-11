//Super Ugly Number
import java.util.Arrays;

public class P313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int number = primes.length;
        int[] index = new int[number];
        int[] dp = new int[n];
        Arrays.fill(index, 0);

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int minVal = primes[0] * dp[index[0]];
            for (int j = 0; j < number; j++) {
                minVal = Math.min(minVal, primes[j] * dp[index[j]]);
            }
            dp[i] = minVal;

            for (int j = 0; j < number; j++) {
                if (minVal == primes[j] * dp[index[j]]) {
                    ++index[j];
                }
            }
        }
        return dp[n - 1];
    }
}