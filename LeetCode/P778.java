import java.util.PriorityQueue;
//Swim in Rising Water
public class P778 {
    public int swimInWater(int[][] g) {
        int m = g.length, n = g[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));

        boolean[][] vs = new boolean[m][n];
        vs[0][0] = true;
        pq.offer(new int[] { 0, 0, g[0][0] });
        int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == m - 1 && cur[1] == n - 1)
                return cur[2];
            for (int[] d : dir) {
                int r = cur[0] + d[0], c = cur[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= m || vs[r][c])
                    continue;
                vs[r][c] = true;
                int max = Math.max(g[r][c], cur[2]);
                pq.offer(new int[] { r, c, max });
            }
        }
        return -1;
    }
}