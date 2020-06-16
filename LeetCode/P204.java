import java.util.Arrays;

//Count Primes
public class P204 {
    public int countPrimes(int n) {
        if (n <= 1)
            return 0;

        boolean prime[] = new boolean[n];
        Arrays.fill(prime, true);

        for (int i = 2; i * i < n; i++) {
            if (prime[i]) {
                for (int j = i * i; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i])
                count++;
        }
        return count;
    }
}