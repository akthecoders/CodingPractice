import java.util.LinkedList;
import java.util.Queue;

//Iterator for Combination
public class P1286 {
    Queue<String> q;

    public P1286(String characters, int combinationLength) {
        q = new LinkedList<>();
        combinationGenerator(characters, "",0, 0, combinationLength);
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }

    public void combinationGenerator(String original, String str, int index, int len, int n) {
        if (len == n) {
            q.add(str);
            return;
        }
        for (int i = index; i < original.length(); i++) {
            if (!str.isEmpty() && (str.charAt(str.length() - 1) == original.charAt(i)))
                continue;
            combinationGenerator(original, str + original.charAt(i), i, len + 1, n);
        }
    }
}