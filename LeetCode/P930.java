import java.util.HashMap;
import java.util.Map;

//Binary Subarrays With Sum
public class P930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int N = A.length;
        int[] P = new int[N + 1];
        for (int i = 0; i < N; i++) {
            P[i + 1] = P[i] + A[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int x : P) {
            ans += map.getOrDefault(x, 0);
            map.put(x + S, map.getOrDefault(x + S, 0) + 1);
        }

        for (int x : P)
            System.out.print(x + " ");
        System.out.println();
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue() + " ");
        });

        return ans;
    }
}