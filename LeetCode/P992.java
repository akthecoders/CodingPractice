//Subarrays with K Different Integers
import java.util.HashMap;
import java.util.Map;

public class P992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return subArrayFinder(A, K) - subArrayFinder(A, K - 1);
    }

    public int subArrayFinder(int A[], int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int lft = 0;
        int rgt = 0;
        int result = 0;

        for (rgt = 0; rgt < A.length; rgt++) {
            int ele = A[rgt];
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            if (map.size() <= K) {
                result += (rgt - lft + 1);
            } else {
                while (map.size() > K) {
                    int rollOut = A[lft++];
                    map.put(rollOut, map.get(rollOut) - 1);
                    if (map.get(rollOut) == 0) {
                        map.remove(rollOut);
                    }
                }
                result += (rgt - lft + 1);
            }
        }
        return result;
    }
}