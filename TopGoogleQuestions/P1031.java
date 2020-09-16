// Maximum Sum of Two Non-Overlapping Subarrays
public class P1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length;
        for (int i = 1; i < n; i++)
            A[i] += A[i - 1];

        int res = 0;

        int l_max = A[L - 1];
        int m_max = A[M - 1];

        for (int i = L; i + M - 1 < n; i++) {
            res = Math.max(res, l_max + A[i + M - 1] - A[i - 1]);
            l_max = Math.max(l_max, A[i] - A[i - L]);
        }

        l_max = A[L - 1];
        m_max = A[M - 1];

        for (int i = M; i + L - 1 < n; i++) {
            res = Math.max(res, m_max + A[i + L - 1] - A[i - 1]);
            m_max = Math.max(m_max, A[i] - A[i - M]);
        }

        return res;
    }
}
