// Is Graph Bipartite?

import java.util.*;
public class P785 {
    public boolean isBipartite(int[][] graph) {
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

        int color[] = new int[N];
        Arrays.fill(color, -1);

        boolean ans = true;
        for (int i = 0; i < N; i++) {
            if (color[i] == -1) {
                ans &= isGraphBipartite(i, color, map, 1);
            }
        }
        return ans;
    }

    public boolean isGraphBipartite(int pos, int[] color, HashMap<Integer, ArrayList<Integer>> map, int c) {
        if (color[pos] != -1 && color[pos] != c) {
            return false;
        }

        color[pos] = c;

        ArrayList<Integer> list = map.get(pos);
        for (int i = 0; i < list.size(); i++) {
            int p = list.get(i);
            if (color[p] == -1) {
                if (!isGraphBipartite(p, color, map, 1 - c)) {
                    return false;
                }
            } else if (color[p] != -1 && color[p] != 1 - c) {
                return false;
            }
        }
        return true;
    }
}