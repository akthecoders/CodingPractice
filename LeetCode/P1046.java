import java.util.Collections;
import java.util.PriorityQueue;

//Last Stone Weight
public class P1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones) {
            pQ.add(x);
        }
        while (pQ.size() > 1) {
            int big = pQ.poll();
            int small = pQ.poll();
            if (big != small) {
                pQ.add(big - small);
            }
        }
        if (pQ.size() == 0) {
            return 0;
        }
        return pQ.poll();
    }
}