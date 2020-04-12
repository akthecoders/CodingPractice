import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    private int V;
    private LinkedList<Integer> adj[];

    @SuppressWarnings("unchecked") 
    public BFS(int v) {
        V = v;
        adj = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void traverse(int v) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);

        while(!queue.isEmpty()) {
            v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()) {
                int n = i.next(); 
                if (!visited[n]) { 
                    visited[n] = true; 
                    queue.add(n); 
                }
            }
        }

    }
    public static void main(String[] args) {
        BFS g = new BFS(4); 
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
        g.traverse(2); 
    }
}