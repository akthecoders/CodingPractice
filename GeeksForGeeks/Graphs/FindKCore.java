import java.util.*;

public class FindKCore {
    int V;
    Vector<Integer>[] adj;
    @SuppressWarnings("unchecked")
    FindKCore(int V) {
        this.V = V;
        this.adj = new Vector[V];

        for (int i = 0; i < V; i++)
            adj[i] = new Vector<>();
    }

    void addEdge(int u, int v) {
        this.adj[u].add(v);
        this.adj[v].add(u);
    }

    void printKCores(int k) {
        boolean visited[] = new boolean[V];
        int[] vDegree = new int[V];

        Arrays.fill(visited, false);
        int minDeg = Integer.MAX_VALUE;
        int startV = 0;

        for(int i = 0; i  < V; i++) {
            vDegree[i] = adj[i].size();
            if(vDegree[i] < minDeg) {
                minDeg = vDegree[i];
                startV = i;
            }
        }

        DFSUtil(startV, visited, vDegree, k);

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited, vDegree, k);
            }
        }

        for(int i = 0; i < V; i++) {
            if(vDegree[i] >= k) {
                System.out.printf("\n[%d]", i); 
                for (int j : adj[i]) 
                if (vDegree[j] >= k) 
                    System.out.printf(" -> %d", j); 

            }
        }
    }

    public boolean DFSUtil(int v, boolean[] visited, int[] vDegree, int k) {

        visited[v] = true;
        for(int i: adj[v]) {
            if(vDegree[v] < k) {
                vDegree[i]--;
            }

            if(!visited[i]) {
                if(DFSUtil(i, visited, vDegree, k)) {
                    vDegree[v]--;
                }
            }
        }

        return (vDegree[v] < k);
    }

    public static void main(String[] args) {
        int k = 3;
        FindKCore g1 = new FindKCore(9);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(3, 7);
        g1.addEdge(4, 6);
        g1.addEdge(4, 7);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.printKCores(k);
        System.out.println();
        FindKCore g2 = new FindKCore(13);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(1, 4);
        g2.addEdge(1, 5);
        g2.addEdge(1, 6);
        g2.addEdge(2, 7);
        g2.addEdge(2, 8);
        g2.addEdge(2, 9);
        g2.addEdge(3, 10);
        g2.addEdge(3, 11);
        g2.addEdge(3, 12);
        g2.printKCores(k);
    }
}