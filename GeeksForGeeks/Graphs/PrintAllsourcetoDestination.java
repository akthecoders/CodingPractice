import java.util.ArrayList;
import java.util.List;

public class PrintAllsourcetoDestination {
    private int V = 5;
    
    @SuppressWarnings("unchecked")
    private ArrayList<Integer>[] adj = new ArrayList[V];

    public PrintAllsourcetoDestination() {
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void printAllPaths(int s, int d) {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<Integer>();
        pathList.add(s);

        printAllPathUtil(s, d, pathList, visited);
    }

    public void printAllPathUtil(Integer s, Integer d, List<Integer> localPathList, boolean[] visited ) {
        visited[s] = true;

        if(s.equals(d)) {
            System.out.println(localPathList);
            visited[s]= false; 
            return ; 
        }
        else {
            for(int i = 0; i < adj[s].size(); i++) {
                    int n = adj[s].get(i);
                    if(!visited[n]) {
                        localPathList.add(n);
                        printAllPathUtil(n, d, localPathList, visited);
                        localPathList.remove(n);
                    }
            }
        }

    }

    public static void main(String[] args) {
        PrintAllsourcetoDestination g = new PrintAllsourcetoDestination();
        g.addEdge(0,1); 
        g.addEdge(0,2); 
        g.addEdge(0,3); 
        g.addEdge(2,0); 
        g.addEdge(2,1); 
        g.addEdge(1,3); 
      
        int s = 2; 
        int d = 3; 
      
        System.out.println("Following are all different paths from "+s+" to "+d); 
        g.printAllPaths(s, d); 
    }
}