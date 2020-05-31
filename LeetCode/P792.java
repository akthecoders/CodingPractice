import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//Number of Matching Subsequences
public class P792 {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        char[] ca = S.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (String x : words)
            map.put(x, map.getOrDefault(x, 0) + 1);
        for (String word : map.keySet())
            if (isSubsequence(word, ca))
                res += map.get(word);
        return res;
    }

    private boolean isSubsequence(String s, char[] ca) {
        if (s.length() == 0)
            return true;
        if (s.length() > ca.length)
            return false;
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray())
            q.offer(c);
        for (char c : ca) {
            if (c == q.peek())
                q.poll();
            if (q.isEmpty())
                return true;
        }
        return false;
    }
}