//Sort Characters By Frequency
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P451 {
    class Pair implements Comparable<Pair> {
        String d;
        int f;

        Pair(String digit, int freq) {
            this.d = digit;
            this.f = freq;
        }

        public int compareTo(Pair p) {
            return p.f - this.f;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> hMap = new HashMap<>();
        for (Character x : s.toCharArray()) {
            hMap.put(x, hMap.getOrDefault(x, 0) + 1);
        }
        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> itr : hMap.entrySet()) {
            Character key = itr.getKey();
            int value = itr.getValue();
            pQ.add(new Pair(Character.toString(key), value));
        }

        String result = "";
        while (!pQ.isEmpty()) {
            Pair p = pQ.poll();
            int freq = p.f;
            String st = p.d;
            for (int i = 0; i < freq; i++) {
                result += st;
            }
        }
        return result;
    }
}