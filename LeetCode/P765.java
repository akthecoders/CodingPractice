// Couple Holding Hands.

public class P765 {
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UnionFind u = new UnionFind(N);
        
        for(int i = 0; i < N; i++) {
            int x = row[2*i];
            int y = row[2*i + 1];
            u.union(x/2, y/2);
        }
        
        return N - u.count;
    }
    
    class UnionFind {
        private int[] parents;
        public int count;
        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            count = n;
        }
        private int find(int i) {
            if (parents[i] == i) {
                return i;
            }
            parents[i] = find(parents[i]);
            return parents[i];
        }
        public void union(int i, int j) {
            int a = find(i);
            int b = find(j);
            if (a != b) {
                parents[a] = b;
                count--;
            }
        }
    }
}