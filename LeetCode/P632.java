import java.util.List;
import java.util.PriorityQueue;

//Smallest Range Covering Elements from K Lists
public class P632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0)
            return null;
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {

            if (a[0] - b[0] == 0)
                return a[1] - b[1] == 0 ? a[2] - b[2] : a[1] - b[1];
            return a[0] - b[0];
        });
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[] { nums.get(i).get(0), i, 0 });
            max = Math.max(nums.get(i).get(0), max);
        }
        int w = Integer.MAX_VALUE;
        int[] res = new int[2];
        res[0] = pq.peek()[0];
        res[1] = max;
        w = max - pq.peek()[0];
        while (true) {

            if (w > max - pq.peek()[0]) {
                w = max - pq.peek()[0];
                res[0] = pq.peek()[0];
                res[1] = max;
            }
            int[] top = pq.poll();
            if (nums.get(top[1]).size() - 1 == top[2])
                break;
            max = Math.max(nums.get(top[1]).get(top[2] + 1), max);
            pq.add(new int[] { nums.get(top[1]).get(top[2] + 1), top[1], top[2] + 1 });
        }
        return res;
    }
}