// Minimum Height Trees

import java.util.*;
import java.util.stream.Collectors;

public class P310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0 && n == 1)
            return Arrays.asList(0);
        int[] indegree = new int[n];
        int[] from = new int[edges.length];
        int[] to = new int[edges.length];
        int p = 0;
        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            from[p] = edges[i][0];
            to[p++] = edges[i][1];
        }
        int[][] graph = construct(n, from, to);
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.add(i);
            }
        }

        int V = n;
        while (V > 2) {
            int k = q.size();
            for (int i = 0; i < k; i++) {
                int u = q.poll();
                V--;
                for (int z : graph[u]) {
                    indegree[z]--;
                    if (indegree[z] == 1) {
                        q.add(z);
                    }
                }

            }
        }

        return q.stream().collect(Collectors.toList());
    }

    public int[][] construct(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for (int f : from)
            p[f]++;
        for (int t : to)
            p[t]++;
        for (int i = 0; i < n; i++)
            g[i] = new int[p[i]];
        for (int i = 0; i < from.length; i++) {
            g[from[i]][--p[from[i]]] = to[i];
            g[to[i]][--p[to[i]]] = from[i];
        }
        return g;
    }
}