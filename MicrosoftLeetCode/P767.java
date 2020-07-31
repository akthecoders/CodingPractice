import java.util.HashMap;
import java.util.PriorityQueue;

//Reorganize String
public class P767 {
    class Pair implements Comparable<Pair> {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public int compareTo(Pair o) {
            return o.count - this.count;
        }
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>();

    public String reorganizeString(String S) {
        if (S.length() == 0)
            return S;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < 26; ++i) {
            if (map.getOrDefault((char) ('a' + i), 0) > 0) {
                if (map.get((char) ('a' + i)) > (S.length() + 1) / 2)
                    return "";
                pq.add(new Pair((char) ('a' + i), map.get((char) ('a' + i))));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() >= 2) {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();

            sb.append(p1.c);
            sb.append(p2.c);

            if (--p1.count > 0)
                pq.add(new Pair(p1.c, p1.count));
            if (--p2.count > 0)
                pq.add(new Pair(p2.c, p2.count));
        }

        if (pq.size() > 0)
            sb.append(pq.poll().c);
        return sb.toString();

    }
}