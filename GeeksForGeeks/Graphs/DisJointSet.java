
public class DisJointSet {
    int V, E;
    Edge edge[];
  
    class Edge { 
        int src, dest; 
    }; 
  
    DisJointSet(int v,int e) { 
        V = v; 
        E = e; 
        edge = new Edge[E]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    } 

    public int find(int[] parent, int node) {
        if (parent[node] == -1) 
            return node; 
        return find(parent, parent[node]);
    }

    public void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    public int isCycle(DisJointSet graph) {
        int parent[] = new int[graph.V];
        for (int i=0; i<graph.V; ++i) 
            parent[i]=-1; 

        for(int i = 0; i < graph.E; i++) {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph .find(parent, graph.edge[i].dest);

            if(x == y) {
                return 1;
            }
            graph.union(parent, x, y);
        }    
        return 0;
    }

    public static void main(String[] args) {
        int V = 3, E = 3; 
        DisJointSet graph = new DisJointSet(V, E); 
  
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
  
        graph.edge[1].src = 1; 
        graph.edge[1].dest = 2; 
  
        graph.edge[2].src = 0; 
        graph.edge[2].dest = 2; 
  
        if (graph.isCycle(graph)==1) 
            System.out.println( "graph contains cycle" ); 
        else
            System.out.println( "graph doesn't contain cycle" ); 
    }
}