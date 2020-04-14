import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class BidirectionalSearch {
    private int V;
    private ArrayList<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public BidirectionalSearch(int v) {
        V = v;
        adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public int bidirectionalSearch(int s, int d) {
        boolean sVisited[] = new boolean[V];
        boolean dVisited[] = new boolean[V];

        Arrays.fill(sVisited, false);
        Arrays.fill(dVisited, false);

        int sParent[] = new int[V];
        int dParent[] = new int[V];

        sParent[s] = -1;
        dParent[d] = -1;

        Queue<Integer> sQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();
        int intersect = -1;

        sQ.add(s);
        dQ.add(d);

        sVisited[s] = true;
        dVisited[d] = true;

        while (!sQ.isEmpty() && !dQ.isEmpty()) {
            BFSUtil(sQ, sVisited, sParent);
            BFSUtil(dQ, dVisited, dParent);

            intersect = isIntersecting(sVisited, dVisited);

            if (intersect != -1) {
                System.out.println("Path Exist between " + s + " ->  " + d);
                System.out.println("Intersection is at " + intersect);

                printPath(sParent, dParent, s, d, intersect);
                return 1;
            }
        }
        return -1;
    }

    public void BFSUtil(Queue<Integer> q, boolean[] visited, int[] parent) {
        int temp = q.poll();
        q.peek();

        for (int i = 0; i < adj[temp].size(); i++) {
            int num = adj[temp].get(i);
            if (!visited[num]) {
                visited[num] = true;
                parent[num] = temp;
                q.add(num);
            }
        }
    }

    public void printPath(int[] sParent, int[] dParent, int s, int d, int intersect) {
        Vector<Integer> vec = new Vector<>();
        int i = intersect;
        vec.add(i);
        while (i != s) {
            vec.add(sParent[i]);
            i = sParent[i];
        }
        Collections.reverse(vec);

        i = intersect;
        while (i != d) {
            vec.add(dParent[i]);
            i = dParent[i];
        }

        System.out.println(vec);

    }

    public int isIntersecting(boolean[] sVisited, boolean[] dVisited) {
        for (int i = 0; i < V; i++) {
            if (sVisited[i] && dVisited[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 15;
        int s = 0;
        int t = 14;

        BidirectionalSearch g = new BidirectionalSearch(n);

        g.addEdge(0, 4);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(4, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(8, 10);
        g.addEdge(9, 11);
        g.addEdge(9, 12);
        g.addEdge(10, 13);
        g.addEdge(10, 14);

        if (g.bidirectionalSearch(s, t) == -1) {
            System.out.println("Path don't exist");
        }
    }
}