//Top K Frequent Words

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P692 {
    class Pair implements Comparable<Pair> {
        String d;
        int f;

        Pair(String digit, int freq) {
            this.d = digit;
            this.f = freq;
        }

        public int compareTo(Pair p) {
            if (p.f == this.f) {
                return this.d.compareTo(p.d);
            }
            return p.f - this.f;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hMap = new HashMap<>();
        for (String x : words) {
            hMap.put(x, hMap.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        for (Map.Entry<String, Integer> itr : hMap.entrySet()) {
            String key = itr.getKey();
            int value = itr.getValue();
            pQ.add(new Pair(key, value));
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pQ.poll().d);
        }
        return result;
    }
}