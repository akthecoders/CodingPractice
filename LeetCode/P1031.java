//Maximum Sum of Two Non-Overlapping Subarrays
public class P1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                prefix[i] = A[i];
                continue;
            }
            prefix[i] = prefix[i - 1] + A[i];
        }
        int lmax = prefix[L - 1], mmax = prefix[M - 1];
        int max1 = 0;
        int max2 = 0;
        for (int i = L; i <= n - M; i++) {
            int mSum = prefix[i + M - 1] - prefix[i] + A[i];
            max1 = Math.max(max1, mSum + lmax);
            lmax = Math.max(lmax, prefix[i] - prefix[i - L]);
        }
        for (int i = M; i <= n - L; i++) {
            int lSum = prefix[i + L - 1] - prefix[i] + A[i];
            max2 = Math.max(max2, lSum + mmax);
            mmax = Math.max(mmax, prefix[i] - prefix[i - M]);
        }
        return Math.max(max1, max2);
    }
}