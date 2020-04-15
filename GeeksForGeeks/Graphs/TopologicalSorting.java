import java.util.*;

public class TopologicalSorting {
    private int V; 
    private LinkedList<Integer> adj[];
  
    @SuppressWarnings("unchecked")
    TopologicalSorting(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<>(); 
    } 
  
    void addEdge(int v,int w) { adj[v].add(w); } 

    public void topologicalSort() {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                topologicalSort(i, stack, visited);  
            }
        }
        while (stack.empty()==false) 
            System.out.print(stack.pop() + " "); 
    }

    public void topologicalSort(Integer v, Stack<Integer> stack, boolean visited[]) {
        visited[v] = true;

        for(int i = 0; i < adj[v].size(); i++) {
            Integer p = adj[v].get(i);
            if(!visited[p]) {
                topologicalSort(p, stack, visited);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        TopologicalSorting g = new TopologicalSorting(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
  
        System.out.println("Following is a Topological " + 
                           "sort of the given graph"); 
        g.topologicalSort(); 
    }
}