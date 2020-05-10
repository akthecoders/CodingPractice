//K Closest Points to Origin
import java.util.PriorityQueue;

public class P973 {
    class Pair implements Comparable<Pair> {
        int dist, x, y;

        Pair(int dist, int x, int y) {
            this.dist = dist;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair other) {
            return this.dist - other.dist;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        int dist = 0, x = 0, y = 0;
        for (int i = 0; i < points.length; i++) {
            x = points[i][0];
            y = points[i][1];
            dist = Math.abs(x * x) + Math.abs(y * y);
            pQ.offer(new Pair(dist, x, y));
        }
        int result[][] = new int[K][2];
        for (int i = 0; i < K; i++) {
            Pair p = pQ.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;
    }
}