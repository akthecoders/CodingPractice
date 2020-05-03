// Shortest Subarray with Sum at Least K
import java.util.*;
public class P862 {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int min = n + 1;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = arr[i] + A[i];
        }
        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && arr[i] - arr[dq.peekFirst()] >= K) {
                min = Math.min(min, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && arr[i] - arr[dq.peekLast()] <= 0) {
                dq.pollLast();
            }

            dq.offer(i);
        }

        return min == n + 1 ? -1 : min;
    }
}