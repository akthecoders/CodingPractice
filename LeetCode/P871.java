import java.util.Collections;
import java.util.PriorityQueue;

//Minimum Number of Refueling Stops
public class P871 {
    public int minRefuelStops(int target, int tank, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0, prev = 0;
        for (int[] station : stations) {
            int location = station[0];
            int capacity = station[1];
            tank -= location - prev;
            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll();
                ans++;
            }

            if (tank < 0)
                return -1;
            pq.offer(capacity);
            prev = location;
        }

        tank -= target - prev;
        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll();
            ans++;
        }
        if (tank < 0)
            return -1;
        return ans;
    }
}