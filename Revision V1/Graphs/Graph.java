package Graphs;
import java.util.*;

public class Graph {
    Map<Integer, List<GraphEdge>> graph;
    GraphType graphType;
    int numNodes;
    public Graph(GraphType graphType, int numNodes) {
        graph = new HashMap<>();
        this.graphType = graphType;
        this.numNodes = numNodes;
    }

    public List<GraphEdge> getEdgesFrom(int from) {
        return graph.get(from);
    }

    public void addEdge(int from , int to, int cost) {
        switch (this.graphType) {
            case DIRECTED:
                add(from, to , cost);
                break;
            case UNDIRECTED:
                add(from, to , cost);
                add(to, from, cost);
                break;
        }
    }   
    
    public void bfs(int startNode) {
        bfs(startNode, new boolean[this.numNodes]);
    }
    
    private int bfs(int startNode, boolean visited[]) {

        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        visited[startNode] = true;
        while(!q.isEmpty()) {
            int nodes = q.size();
            for(int i = 0; i < nodes; i++) {
                int from = q.poll();
                System.out.println(from);
                List<GraphEdge> edges = getEdgesFrom(from);
                 if(edges != null && !edges.isEmpty()) {
                    for(GraphEdge edge: edges) {
                        if(!visited[edge.to]) {
                            visited[edge.to] = true;
                            count++;
                            q.offer(edge.to);
                        }
                    }
                }
            }
        }
        return count;
    }

    public void add(int from, int to, int cost) {
        List<GraphEdge> list = graph.get(from);
        if(list == null) {
            list = new ArrayList<GraphEdge>();
            graph.put(from, list);
        }
        list.add(new GraphEdge(from, to , cost));
    }
}
