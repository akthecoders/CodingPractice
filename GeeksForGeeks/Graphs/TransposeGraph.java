import java.util.ArrayList;

public class TransposeGraph {
    private static int V = 5;
    @SuppressWarnings("unchecked")
    private static ArrayList<Integer>[] adj = new ArrayList[V];
    @SuppressWarnings("unchecked")
    private static ArrayList<Integer>[] tr = new ArrayList[V];

    public static void addEdge(int u, int v, boolean choice) {
        if (choice) {
            tr[u].add(v);
        } else {
            adj[u].add(v);
        }
    }

    public static void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + "--> ");
            for (int j = 0; j < tr[i].size(); j++)
                System.out.print(tr[i].get(j) + " ");
            System.out.println();
        }
    }

    public static void getTranspose() {
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < adj[i].size(); j++) {
                addEdge(adj[i].get(j), i, true);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
            tr[i] = new ArrayList<Integer>();
        }
        addEdge(0, 1, false);
        addEdge(0, 4, false);
        addEdge(0, 3, false);
        addEdge(2, 0, false);
        addEdge(3, 2, false);
        addEdge(4, 1, false);
        addEdge(4, 3, false);
        getTranspose();
        printGraph();
    }
}