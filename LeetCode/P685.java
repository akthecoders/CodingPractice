// Redundant Connections 2

public class P685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;

        int[] indegree = new int[n + 1];
        int found = -1;
        for (int[] edge : edges) {
            indegree[edge[1]]++;
            if (indegree[edge[1]] == 2) {
                found = edge[1];
                break;
            }
        }
        if (found == -1)
            return detectCycle(edges, new int[2]);

        for (int i = n - 1; i >= 0; i--) {
            if (edges[i][1] == found) {
                int[] redundant = detectCycle(edges, edges[i]);
                if (redundant == null)
                    return edges[i];
            }
        }
        return new int[0];
    }

    private int[] detectCycle(int[][] edges, int[] skip) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] edge : edges) {
            if (edge[0] == skip[0] && edge[1] == skip[1])
                continue;
            if (!uf.union(edge[0], edge[1]))
                return edge;
        }
        return null;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++)
                parent[i] = i;
            rank = new int[n + 1];
        }

        int find(int a) {
            if (parent[a] != a)
                parent[a] = find(parent[a]);
            return parent[a];
        }

        boolean union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);
            if (p1 == p2)
                return false;
            if (rank[p1] > rank[p2]) {
                rank[p1]++;
                parent[p2] = p1;
            } else {
                rank[p2]++;
                parent[p1] = p2;
            }
            return true;
        }
    }
}