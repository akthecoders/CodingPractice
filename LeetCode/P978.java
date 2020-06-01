//Longest Turbulent Subarray
public class P978 {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int sign = 0;
        int pre = 0;
        int ans = 0;
        for (int i = 0, j = 0; j < N; j++) {
            if (j == N - 1)
                return Math.max(ans, j - i + 1);
            sign = Integer.compare(A[j], A[j + 1]);
            if (sign == 0) {
                ans = Math.max(ans, j - i + 1);
                i = j + 1;
            } else if (sign != -pre) {
                ans = Math.max(ans, j - i + 1);
                i = j;
            }
            pre = sign;
        }
        return ans;
    }
}