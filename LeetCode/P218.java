import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//The Skyline Problem
public class P218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new int[] { b[0], b[2] });
            list.add(new int[] { b[1], -b[2] });
        }

        Collections.sort(list, (a1, a2) -> {
            if (a1[0] == a2[0])
                return a2[1] - a1[1];
            return a1[0] - a2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        pq.add(-1);
        for (int pair[] : list) {
            int x = pair[0];
            int y = pair[1];
            if (y > pq.peek()) {
                List<Integer> l = new ArrayList<>();
                l.add(x);
                l.add(y);
                res.add(l);
            }
            if (y > 0)
                pq.add(y);
            else {
                int top = pq.peek();
                if (-y != top) {
                    pq.remove(-y);
                } else {
                    pq.remove(-y);
                    if (-y == pq.peek())
                        continue;
                    List<Integer> l = new ArrayList<>();
                    l.add(x);
                    if (pq.peek() == -1)
                        l.add(0);
                    else
                        l.add(pq.peek());
                    res.add(l);
                }
            }
        }
        return res;
    }
}