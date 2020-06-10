import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

//Cheapest Flights Within K Stops
public class P787 {
    HashMap<Integer, LinkedList<int[]>> graph;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length == 0 || flights == null)
            return 0;

        graph = new HashMap<Integer, LinkedList<int[]>>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<int[]>());
        }
        for (int k = 0; k < flights.length; k++) {
            graph.get(flights[k][0]).add(new int[] { flights[k][1], flights[k][2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        pq.offer(new int[] { 0, src, K + 1 });
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0];
            int curr = top[1];
            int level = top[2];

            if (curr == dst) {
                return cost;
            }

            if (level > 0) {
                LinkedList<int[]> adjList = graph.get(curr);
                for (int k = 0; k < adjList.size(); k++) {
                    int[] temp = adjList.get(k);
                    pq.offer(new int[] { cost + temp[1], temp[0], level - 1 });
                }
            }
        }
        return -1;
    }
}