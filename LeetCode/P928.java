// Min Malware Spread II
import java.util.*;
public class P928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;

        Arrays.sort(initial);

        Set<Integer> mal = new HashSet<>();
        for (int i : initial) {
            mal.add(i);
        }

        int num = -1;
        int res = -1;
        for (int v : initial) {
            int save = 0;
            Set<Integer> visited = new HashSet<>();
            visited.add(v);

            for (int i = 0; i < n; i++) {
                if (v != i && graph[v][i] == 1) {
                    int tmp = dfs(i, visited, graph, mal);
                    if (tmp < 0)
                        continue;
                    save += tmp;
                }
            }
            if (save > num) {
                num = save;
                res = v;
            }
        }

        return res;
    }

    public int dfs(int curr, Set<Integer> visited, int[][] graph, Set<Integer> mal) {
        if (!visited.add(curr)) {
            return 0;
        }
        if (mal.contains(curr)) {
            return -1;
        }

        int save = 1;

        for (int j = 0; j < graph.length; j++) {
            if (curr != j && graph[curr][j] == 1) {
                int tmp = dfs(j, visited, graph, mal);
                if (tmp < 0) {
                    mal.add(curr);
                    return -1;
                }
                save += tmp;
            }

        }

        return save;
    }
}