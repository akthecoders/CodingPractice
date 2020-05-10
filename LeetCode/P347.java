import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Top K Frequent Elements
public class P347 {
    class Pair implements Comparable<Pair> {
        int d;
        int f;

        Pair(int digit, int freq) {
            this.d = digit;
            this.f = freq;
        }

        public int compareTo(Pair p) {
            return p.f - this.f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        for (int x : nums) {
            hMap.put(x, hMap.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> itr : hMap.entrySet()) {
            int key = itr.getKey();
            int value = itr.getValue();
            pQ.add(new Pair(key, value));
        }

        int result[] = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pQ.poll().d;
        }
        return result;
    }
}