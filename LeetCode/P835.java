import java.util.HashMap;
import java.util.Map;

//Image Overlap
public class P835 {
    public int largestOverlap(int[][] A, int[][] B) {
        Map<String, Integer> vectorMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 1)
                    continue;
                for (int k = 0; k < B.length; k++) {
                    for (int l = 0; l < B[0].length; l++) {
                        if (B[k][l] != 1)
                            continue;
                        String vector = (i - k) + ":" + (j - l);
                        vectorMap.put(vector, vectorMap.getOrDefault(vector, 0) + 1);
                    }
                }
            }
        }
        int max = 0;
        for (int count : vectorMap.values())
            max = Math.max(max, count);
        return max;
    }
}