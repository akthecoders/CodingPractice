import java.util.HashMap;

//4Sum II
public class P454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        if (A != null && A.length != 0) {
            int i, j, sum, N = A.length;
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    sum = A[i] + B[j];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    sum = C[i] + D[j];
                    count += map.getOrDefault(-sum, 0);
                }
            }

        }
        return count;
    }
}