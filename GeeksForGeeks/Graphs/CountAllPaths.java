import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CountAllPaths {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    CountAllPaths(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int countPaths(int s, int d) {
        int countPath = 0;
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        countPath = pathCountUtil(s, d, visited, countPath);
        return countPath;
    }

    public int pathCountUtil(int s, int d, boolean[] visited,int countPath) {
        visited[s] = true;
        if(s == d) {
            countPath++;
        }
        else {
            Iterator<Integer> itr = adj[s].listIterator();
            while(itr.hasNext()) {
                int n = itr.next();
                if(!visited[n]) {
                    countPath = pathCountUtil(n, d, visited, countPath);
                }
            }
        }
        visited[s] = false;

        return countPath;
    }
    
    public static void main(String args[]) {
        CountAllPaths g = new CountAllPaths(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        System.out.println(g.countPaths(s, d));
    }
}