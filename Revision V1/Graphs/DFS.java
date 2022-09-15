package Graphs;

import java.util.*;

public class DFS {
    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int dfs(int at, boolean[] visited, Map<Integer, List<Edge>> graph) {
        if(visited[at]) return 0;
        visited[at] = true;
        int count = 1;
        
        List<Edge> edges = graph.get(at);
        if(edges != null) {
            for(Edge edge: edges)
            count += dfs(edge.to, visited, graph);
        }
        return count;
    }

    public static void main(String[] args) {
        int numNodes = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedGraph(graph, 0, 1, 4);
        addDirectedGraph(graph, 0, 2, 5);
        addDirectedGraph(graph, 1, 2, -2);
        addDirectedGraph(graph, 1, 3, 6);
        addDirectedGraph(graph, 2, 3, 1);
        addDirectedGraph(graph, 2, 2, 10);

        int nodeCount = dfs(0, new boolean[numNodes], graph);
        System.out.println("DFS count starting at node 0: " + nodeCount);
        if(nodeCount != 4) System.err.println("Error with DFS");


    }

    public static void addDirectedGraph(Map<Integer, List<Edge>> graph, int from , int to, int cost) {
        List<Edge> list = graph.get(from);
        if(list == null) {
            list = new ArrayList<Edge>();
            graph.put(from, list);
        }
        list.add(new Edge(from, to , cost));
    }
}
