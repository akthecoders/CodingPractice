// Maximum Frequency Stack
import java.util.*;
public class P895 {
    PriorityQueue<Pair> pq;
    HashMap<Integer, Integer> map;
    int pr = 0; // priority of who came first.

    public P895() {
        pq = new PriorityQueue<>(new FreqComparator());
        map = new HashMap<>();
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        pq.offer(new Pair(x, map.get(x), pr++));
    }

    public int pop() {
        Pair pair = pq.poll();
        map.put(pair.key, map.getOrDefault(pair.key, 0) - 1);
        return pair.key;
    }

    class Pair {
        int key, freq, pr;

        public Pair(int key, int freq, int pr) {
            this.key = key;
            this.freq = freq;
            this.pr = pr;
        }
    }

    class FreqComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            if (p1.freq < p2.freq)
                return 1;
            else if (p1.freq > p2.freq)
                return -1;
            else if (p1.pr < p2.pr)
                return 1;
            else if (p1.pr > p2.pr)
                return -1;
            return 0;
        }
    }
}