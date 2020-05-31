import java.util.HashMap;
import java.util.Map;

//Length of Longest Fibonacci Subsequence
public class P873 {
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int len = A.length;
        int dp[][] = new int[len][len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(A[i], i);
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = 2;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int k = A[i] + A[j];
                if (map.containsKey(k)) {
                    int index = map.get(k);
                    dp[j][index] = dp[i][j] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}