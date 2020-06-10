import java.util.Collections;
import java.util.PriorityQueue;

//Find the Kth Smallest Sum of a Matrix With Sorted Rows
public class P1439 {
    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length, res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        for (int i = 0; i < m; i++) {
            PriorityQueue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder());
            for (int sum : pq) {
                for (int j = 0; j < n; j++) {
                    nq.offer(sum + mat[i][j]);
                    if (nq.size() > k)
                        nq.poll();
                }
            }
            pq = nq;
        }
        return pq.poll();
    }
}