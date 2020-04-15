import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CycleInDirectedGraph {
    private final int V;
    private final List<List<Integer>> adj;

    public CycleInDirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new LinkedList<>());
    }

    private void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public boolean isCyclic() {
        boolean visited[] = new boolean[V];
        boolean path[] = new boolean[V];
        Arrays.fill(visited, false);
        Arrays.fill(path, false);
        for (int i = 0; i < V; i++) {
            if(isCyclicUtil(i, visited, path)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCyclicUtil(int node, boolean[] visited, boolean[] path) {
        if(path[node]) {
            return true;
        }
        if(visited[node]) {
            return false;
        }

        visited[node] = true;
        path[node] = true;

        List<Integer> children = adj.get(node);
        for (Integer c: children)
            if (isCyclicUtil(c, visited, path)) 
                return true; 
                  
        path[node] = false; 
        return false;
    }

    public static void main(String[] args) {
        CycleInDirectedGraph graph = new CycleInDirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't " + "contain cycle");
    }
}