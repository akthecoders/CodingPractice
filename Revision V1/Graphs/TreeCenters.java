package Graphs;

import java.util.*;

public class TreeCenters {

    public static List<Integer> centerTree(Graph graph) {
        int n = graph.numOfNodes();
        int degree[] = new int[n];
        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            degree[i] = graph.getEdgesFrom(i).size();
            if(degree[i] == 0 || degree[i] == 1) {
                leaves.add(i);
                degree[i] = 0;
            }
        }
        int count = leaves.size();
        while(count < n) {
            List<Integer> newLeaves = new ArrayList<>();
            for(int node: leaves) {
                List<GraphEdge> edges = graph.getEdgesFrom(node);
                for(GraphEdge edge: edges) {
                    degree[edge.to]--;
                    if(degree[edge.to] == 0 || degree[edge.to] == 1) {
                        newLeaves.add(edge.to);
                    }
                }
                degree[node] = 0;
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }

        return leaves;
    } 

    public static void main(String[] args) {
        Graph graph = new Graph(GraphType.UNDIRECTED, 5);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 4,3);

        List<Integer> leaves = centerTree(graph);
        for(Integer leave: leaves) System.out.println(leave);
    }
}
