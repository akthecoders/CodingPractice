package Graphs;

import java.util.*;

public class ShortestPathDijikstra {
    
    class Edge {
        int cost;
        int from, to ;

        public Edge(int from, int to, int cost) {
            this.cost = cost;
            this.from = from;
            this.to = to ;
        }
    }

    class Node {
        int id;
        int value;

        public Node(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    Comparator<Node> nodeComparator = new Comparator<Node>() {

        @Override
        public int compare(Node o1, Node o2) {
            if(o1.value == o1.value) return 0;
            return o1.value - o2.value > 0 ? 1 : -1;
        }
        
    };

    int n;
    private int[] dist;
    private Integer[] prev;
    private List<List<Edge>> graph;

    public ShortestPathDijikstra(int n) {
        this.n = n;
        createEmptyGraph();
    }

    public ShortestPathDijikstra(int n, Comparator<Node> comparator) {
        this(n);
        if (comparator == null) throw new IllegalArgumentException("Comparator cannot be null");
        this.nodeComparator = comparator;
    }

    public void addEdge(int from, int to, int cost) {
        graph.get(from).add(new Edge(from, to, cost));
    }

    public List<List<Edge>> getGraph() {
        return graph;
    }

    public int dijikstra(int start, int end) {
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(2 * n, nodeComparator);
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n];
        prev = new Integer[n];

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            visited[n.id] = true;

            if (dist[n.id] < n.value) continue;

            List<Edge> edges = graph.get(n.id);

            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);

                // You cannot get a shorter path by revisiting
                // a node you have already visited before.
                if (visited[edge.to]) continue;

                // Relax edge by updating minimum cost if applicable.
                int newDist = dist[edge.from] + edge.cost;
                if (newDist < dist[edge.to]) {
                prev[edge.to] = edge.from;
                dist[edge.to] = newDist;
                pq.offer(new Node(edge.to, dist[edge.to]));
            }
        }
        if (n.id == end) return dist[end];
    }
      return Integer.MAX_VALUE;
    }

    private void createEmptyGraph() {
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        ShortestPathDijikstra obj = new ShortestPathDijikstra(6);
        obj.addEdge(0, 1, 5);
        obj.addEdge(0, 2, 10);
        obj.addEdge(0, 3, 6);
        obj.addEdge(1, 2, 1);
        obj.addEdge(1, 3, 2);
        obj.addEdge(2, 4, 5);
        obj.addEdge(3, 5, 6);
        obj.addEdge(4, 5, 7);

        System.out.println(obj.dijikstra(0, 5));
    }
}
