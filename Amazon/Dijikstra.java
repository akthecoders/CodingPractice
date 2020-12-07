import java.util.*;

public class Dijikstra {
    private static int dist[];
    private static Set<Integer> settled;
    private static PriorityQueue<Node> pq;
    private static int V; // Number of vertices
    static List<List<Node>> adj;

    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node()
        {
        }

        public Node(int node, int cost)
        {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2)
        {
            if (node1.cost < node2.cost)
                return -1;
            if (node1.cost > node2.cost)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int source = 0;

        adj = new ArrayList<List<Node> >();

        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }

        // Inputs for the DPQ graph
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));
        dijkstra(adj, source);
    }

    public static void dijkstra(List<List<Node> > adj, int src)
    {
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source node to the priority queue 
        pq.add(new Node(src, 0));

        // Distance to the source is 0 
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node  
            // from the priority queue  
            int u = pq.remove().node;

            // adding the node whose distance is 
            // finalized 
            settled.add(u);

            e_Neighbours(u);
        }
    }
    private static void e_Neighbours(int u)
    {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}
