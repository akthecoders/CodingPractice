package Graphs;

import java.util.*;

public class BFS {
    static class Edge {
        int from, to, cost;
        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    
    public static void addDirectedGraph(Map<Integer, List<Edge>> graph, int from , int to, int cost) {
        List<Edge> list = graph.get(from);
        if(list == null) {
            list = new ArrayList<Edge>();
            graph.put(from, list);
        }
        list.add(new Edge(from, to , cost));
    }

    public static int bfs(int startNode, boolean visited[], Map<Integer, List<Edge>> graph) {

        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        visited[startNode] = true;
        while(!q.isEmpty()) {
            int nodes = q.size();
            for(int i = 0; i < nodes; i++) {
                int from = q.poll();
                List<Edge> edges = graph.get(from);
                 if(edges != null && !edges.isEmpty()) {
                    for(Edge edge: edges) {
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

    public static void main(String[] args) {
        int numNodes = 5;
        Map<Integer, List<Edge>> graph = new HashMap<>();
        addDirectedGraph(graph, 0, 1, 4);
        addDirectedGraph(graph, 0, 2, 5);
        addDirectedGraph(graph, 1, 2, -2);
        addDirectedGraph(graph, 1, 3, 6);
        addDirectedGraph(graph, 2, 3, 1);
        addDirectedGraph(graph, 2, 2, 10);

        int nodeCount = bfs(0, new boolean[numNodes], graph);
        System.out.println("DFS count starting at node 0: " + nodeCount);
        if(nodeCount != 4) System.err.println("Error with DFS");
    }
}
