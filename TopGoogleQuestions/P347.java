import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Top K Frequent Elements
public class P347 {
    class Pair implements Comparable<Pair> {
        int key;
        int freq;

        public Pair(int k, int f) {
            this.key = k;
            this.freq = f;
        }

        public int compareTo(Pair o) {
            return o.freq - this.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>();

        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);

        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            q.add(new Pair(itr.getKey(), itr.getValue()));
        }

        int[] result = new int[k];
        int i = 0;
        while (i < k && !q.isEmpty()) {
            result[i++] = q.poll().key;
        }
        return result;
    }
}
