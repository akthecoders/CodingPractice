import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//Smallest String With Swaps
public class P1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] root = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        for (List<Integer> p : pairs)
            union(root, p.get(0), p.get(1));

        Map<Integer, PriorityQueue<Character>> map = new HashMap<Integer, PriorityQueue<Character>>();
        for (int i = 0; i < n; i++) {
            int head = findRoot(root, i);
            root[i] = head;
            if (!map.containsKey(head))
                map.put(head, new PriorityQueue<Character>());
            map.get(head).add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(map.get(root[i]).poll());
        return sb.toString();
    }

    public void union(int[] root, int src, int dest) {
        int srcRoot = findRoot(root, src);
        int destRoot = findRoot(root, dest);
        if (srcRoot != destRoot) {
            root[srcRoot] = destRoot;
        }
    }

    private int findRoot(int[] root, int i) {
        if (root[i] == i)
            return i;
        int r = findRoot(root, root[i]);
        root[i] = r;
        return r;
    }
}