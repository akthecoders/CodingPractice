import java.util.*;

public class DFS {
    private int V;
    private LinkedList<Integer> adj[];
    @SuppressWarnings("unchecked") 
    public DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void traverse(int s) {
        boolean visited[] = new boolean[V];
        traverseUtil(s, visited);
    }

    public void traverseUtil(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        Iterator<Integer> itr = adj[s].listIterator();
        while(itr.hasNext()) {
            int n = itr.next();
            if(!visited[n]) {
                traverseUtil(n, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.traverse(2); 
    }
}