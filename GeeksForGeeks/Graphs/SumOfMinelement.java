import java.util.ArrayList;
import java.util.Arrays;

public class SumOfMinelement {
    private int V = 15;
    ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public SumOfMinelement() {
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public int minimumSumConnectedComponents(int[] a, int n) {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                Integer min = a[i];
                sum += dfs(i, a, min, visited);
            }
        }
        return sum;
    }

    public int dfs(int node, int[] a, Integer min, boolean[] visited) {
        visited[node] = true;
        min = Math.min(min, a[node]);
        for(int i = 0; i < adj[node].size(); i++) {
            int n = adj[node].get(i);
            if(!visited[n]) {
                min = Math.min(min, dfs(n, a, a[n], visited));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int a[] = { 1, 6, 2, 7, 3, 8, 4, 9, 5, 10 };
        SumOfMinelement g = new SumOfMinelement();
        g.addEdge(0, 1);
        g.addEdge(2, 3);
        g.addEdge(4, 5);
        g.addEdge(6, 7);
        g.addEdge(8, 9);
        int n = a.length;
        System.out.println(g.minimumSumConnectedComponents(a, n));
    }

}