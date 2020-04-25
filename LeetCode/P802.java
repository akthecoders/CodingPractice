// Find Eventual Safe States

import java.util.*;
public class P802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> hm = map.get(i);
            if (hm == null) {
                hm = new ArrayList<>();
            }
            for (int j = 0; j < graph[i].length; j++) {
                hm.add(graph[i][j]);
            }
            map.put(i, hm);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N];
        HashSet<Integer> terminal = new HashSet<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            if (checkIfSafe(visited, i, map, terminal)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean checkIfSafe(boolean[] visited, int u, HashMap<Integer, ArrayList<Integer>> graph,
            HashSet<Integer> terminal) {
        if (terminal.contains(u)) {
            return true;
        }

        if (visited[u]) {
            return false;
        }

        visited[u] = true;

        ArrayList<Integer> itr = graph.get(u);
        for (int i = 0; i < itr.size(); i++) {
            int v = itr.get(i);
            if (!checkIfSafe(visited, v, graph, terminal)) {
                return false;
            }
        }
        terminal.add(u);
        return true;
    }
}