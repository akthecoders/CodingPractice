import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int sv;
    int ev;
    int weight;
    Edge(int s, int e, int w) {
        sv = s;
        ev = e;
        weight = w;
    }

    public static Comparator<Edge> getIndexComparator() {
        return new Comparator<Edge>() {
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        };
    }
}

public class Kruskal {

    public static int E = 11;
    public static int V = 6;

    public static void main(String[] args) {
        Edge[] edges = new Edge[11];
        edges[0] = new Edge(0, 1, 1);
        edges[1] = new Edge(0, 2, 5);
        edges[2] = new Edge(2, 3, 10);
        edges[3] = new Edge(0, 3, 4);
        edges[4] = new Edge(1, 3, 3);
        edges[5] = new Edge(1, 2, 6);
        edges[6] = new Edge(3, 4, 7);
        edges[7] = new Edge(2, 4, 8);
        edges[8] = new Edge(4, 5, 2);
        edges[9] = new Edge(2, 5, 9);
        edges[10] = new Edge(3, 5, 6);
        findKruskalMST(edges);
    }

    public static void  findKruskalMST(Edge[] edges) {
        int parent[] = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }

        Arrays.sort(edges, Edge.getIndexComparator());

        Edge[] output = new Edge[V - 1];
        
        findMST(edges, output, parent);

        for (Edge edge : output) {
            System.out.println(edge.sv + " " + edge.ev + " " + edge.weight);
        }
    }

    public static void sortEdges(Edge[] edges) {
        Edge min = edges[0];
        int index = 0;
        for(int i = 0; i < edges.length; i++) {
            for(int j = i; j < edges.length; j++) {
                if(min.weight > edges[j].weight) {
                    min = edges[j];
                    index = j;
                }
            }
            Edge temp = edges[i];
            edges[i] = edges[index];
            edges[index] = temp;
        }
    }

    public static void findMST(Edge[] input, Edge[] output, int[] parent) {
        int count  = 0;
        for(int i = 0; i < E; i++) {
            if(isSafe(input[i], parent)) {
                output[count++] = input[i];
                if(count == output.length) {
                    return;
                }
                makeParent(input[i].sv, input[i].ev, parent);
            }
        }
    }

    public static void makeParent(int p, int c, int[] parent) {
        parent[c] = p;
    }

    public static boolean isSafe(Edge edge, int[] parent) {
        return !(findParent(edge.sv, parent) == findParent(edge.ev, parent));
    }

    public static int findParent(int index, int[] parent) {
        while(parent[index] != index) {
            index = parent[index];
        }
        return index;
    }
}