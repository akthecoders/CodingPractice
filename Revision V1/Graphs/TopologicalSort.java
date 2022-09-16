package Graphs;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

    public static List<Integer> topSort(Graph g) {
        int numNodes = g.numOfNodes();
        List<Integer> ordered = new ArrayList<>();
        boolean visited[] = new boolean[numNodes];
        for(int i = 0; i < numNodes; i++) {
            if(!visited[i]) {
                dfs(i, g, ordered, visited);
            }
        }
        return ordered;
    }

    public static void dfs(int at, Graph g, List<Integer> order, boolean[] visited) {
        if(visited[at]) return;
        visited[at] = true;

        List<GraphEdge> edges = g.getEdgesFrom(at);
        if(edges != null)
            for(GraphEdge edge: edges) {
                dfs(edge.to, g, order, visited);
            }

        order.add(0, at);
    }


    public static void main(String[] args) {
        Graph g = new Graph(GraphType.DIRECTED, 5);
        g.addEdge(0, 1, 0);
        g.addEdge(0, 2, 0);
        g.addEdge(1, 3, 0);
        g.addEdge(2, 3, 0);
        g.addEdge(3, 4, 0);

        List<Integer> sorted = topSort(g);
        for(Integer node: sorted) System.out.println(node + " ");
    }
}
