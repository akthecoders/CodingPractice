import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class CycleInUndirectedGraph {
    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked")
    CycleInUndirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public boolean isCyclic() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int u = 0; u < V; u++) { 
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1)) {
                    return true; 
                }
            }
        }

        return false;
    }

    public boolean isCyclicUtil(int v, boolean[] visited, int parent) {
        
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) { 
                if (isCyclicUtil(i, visited, v)) {
                    return true; 
                }
            } 
            else if (i != parent) {
                return true; 
            }
        }
        return false;
    }

    public static void main(String args[]) {
        CycleInUndirectedGraph g1 = new CycleInUndirectedGraph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");

        CycleInUndirectedGraph g2 = new CycleInUndirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
    }
}