import java.util.Arrays;

//Count Primes
public class P204 {
    public int countPrimes(int n) {
        boolean primes[] = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i; i * j < n; j++) {
                    primes[i * j] = false;
                }
            }
        }

        int result = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                result++;
        }
        return result;
    }
}