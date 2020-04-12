import java.util.ArrayList;
import java.util.Arrays;

public class TransitiveClosure {
    private int vertices;
    private ArrayList<Integer>[] adjList;
    private int[][] tc;

    public TransitiveClosure(int vertices) { 
        this.vertices = vertices;  
        this.tc = new int[this.vertices][this.vertices]; 
        initAdjList();  
    }
    
    @SuppressWarnings("unchecked") 
    private void initAdjList() {
        adjList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    public void transitiveClosure() {
        for(int i = 0; i < vertices; i++) {
            dfsUtil(i, i);
        }
        for (int i = 0; i < vertices; i++) { 
            System.out.println(Arrays.toString(tc[i])); 
        } 
    }

    public void dfsUtil(int u, int v) {
        tc[u][v] = 1;

        for(int adj:adjList[v]) {
            if(tc[u][adj] != 1) {
                dfsUtil(u, adj);
            }
        }
    }

    public static void main(String[] args) {
        TransitiveClosure g = new TransitiveClosure(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " + "matrix is");
        g.transitiveClosure();
    }
}