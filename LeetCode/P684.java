// Redundant Connection Undirected Graph
public class P684 {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        P684 p = new P684();
        int[] res = p.findRedundantConnection(edges);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length + 1;
        UnionFind un = new UnionFind(N);

        for (int[] is : edges) {
            if(un.find(is[0]) == un.find(is[1])) {
                return is;
            }
            un.unionInit(is[0], is[1]);
        }
        return null;
    }

    class UnionFind {
        int count;
        int [] parent;
        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
        }

        public int getCount(){
            return count;
        }

        public void unionInit(int x, int y) {
            int i = find(x);
            int j = find(y);
            if(i != j) {
                parent[i] = j;
                count--;
            }
        }

        public int find(int i) {
            if(parent[i] == i) {
                return i;
            }
            return find(parent[i]);
        }
    }
}