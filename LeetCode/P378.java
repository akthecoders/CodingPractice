//Kth Smallest Element in a Sorted Matrix
import java.util.PriorityQueue;

public class P378 {
    class Pair implements Comparable<Pair> {
        int d;

        Pair(int d) {
            this.d = d;
        }

        public int compareTo(Pair p) {
            return this.d - p.d;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        for (int[] r : matrix) {
            for (int x : r)
                pQ.add(new Pair(x));
        }
        for (int i = 0; i < k - 1; i++) {
            pQ.poll();
        }
        return pQ.poll().d;
    }
}