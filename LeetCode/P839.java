// Similar String Groups
import java.util.*;
public class P839 {
    public int numSimilarGroups(String[] A) {
        HashMap<String, Set<String>> g = new HashMap<>();
        for (String s : A) {
            g.put(s, new HashSet<>());
        }

        buildGraph(g, A);
        int count = 0;
        Set<String> visited = new HashSet<>();
        for (String key : g.keySet()) {
            if (visited.contains(key))
                continue;
            dfs(visited, g, key);
            count++;
        }
        return count;
    }

    public void dfs(Set<String> visited, HashMap<String, Set<String>> g, String curr) {
        visited.add(curr);

        if (g.get(curr).size() == 0) {
            return;
        }
        for (String s : g.get(curr)) {
            if (visited.contains(s))
                continue;
            dfs(visited, g, s);
        }
    }

    public void buildGraph(HashMap<String, Set<String>> g, String[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(A[i], A[j])) {
                    g.get(A[i]).add(A[j]);
                    g.get(A[j]).add(A[i]);
                }
            }
        }
    }

    public boolean isSimilar(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}