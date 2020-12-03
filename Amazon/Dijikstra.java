import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijikstra {

    static class Node implements Comparator<Node> {
        int node;
        int cost;

        public Node(int n, int c) {
            this.node = n;
            this.cost = c;
        }

        public int compare(Node node1, Node node2) {
            return node1.cost - node2.cost;
        }
    }

    public static void algo(int[][] graph, int source, int N) {
        PriorityQueue<Node> pQ = new PriorityQueue<>();
        pQ.add(new Node(source, 0));
        int dist[] = new int[N];

        for (int i = 0; i < N; i++) 
            dist[i] = Integer.MAX_VALUE; 

        Set<Integer> visited = new HashSet<>();
        
        while(visited.size() < N) {
            Node vNode = pQ.poll();
            int u = vNode.node;
            visited.add(u);
            exploreNeighbour(u, visited, pQ, graph, N, dist);
        }
    }

    public static void exploreNeighbour(int u, Set<Integer> visited, PriorityQueue<Node> pQ, int[][] graph, int N, int[] dist) {
        for(int i = 0; i < graph[u].length; i++) {
            if(!visited.contains(i)) {
                int d = graph[u][i];
                int newDist = dist[u] + d;
                if(newDist < d) {
                    dist[i] = newDist;
                }
                pQ.add(new Node(i, dist[i]));
            }
        }
    }
}


