import java.util.*; 

public class CountNoOfTreesInForest {
    private int V;
    private LinkedList<Integer> adj[];
    
    @SuppressWarnings("unchecked")
    CountNoOfTreesInForest(int v)  {  
        V = v;  
        adj = new LinkedList[v];  
        for (int i = 0; i <  v; ++i)  
            adj[i] = new LinkedList<>();  
    }  
  
    void addEdge(int v, int w)  {  
        adj[v].add(w);
    }  

    public int countTrees() {
        int res = 0;
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited);
                res++;
            }
        }
        return res;
    }

    public void DFSUtil(int n , boolean[] visited) {
        visited[n] = true;

        Iterator<Integer> itr = adj[n].listIterator();
        while(itr.hasNext()) {
            int p = itr.next();
            if(!visited[p]) {
                DFSUtil(p, visited);
            }
        }

    }

    public static void main(String[] args) {
        CountNoOfTreesInForest g = new CountNoOfTreesInForest(5);    
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);
        System.out.println(g.countTrees());
    }
}