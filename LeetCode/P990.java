// Satisfiability of Equality Equations

public class P990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind u = new UnionFind(26);

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '=') {
                u.union(u.findParent(equations[i].charAt(0) - 'a'), u.findParent(equations[i].charAt(3) - 'a'));
            }
        }

        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                if (u.findParent(equations[i].charAt(0) - 'a') == u.findParent(equations[i].charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;

    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int u) {
            if (parent[u] == u) {
                return u;
            }
            return findParent(parent[u]);
        }

        public void union(int u, int v) {
            int x = findParent(u);
            int y = findParent(v);
            if (x != y) {
                parent[x] = y;
            }
        }
    }
}