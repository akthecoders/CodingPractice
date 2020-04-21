import java.util.Arrays;
import java.util.Scanner;

public class Dijikstra {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        int[][] edges = new int[V][V];
        for (int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            int weight = s.nextInt();

            edges[sv][ev] = weight;
            edges[ev][sv] = weight;
        }
        digistraAlgo(edges, E, V);
        s.close();
    }

    public static void digistraAlgo(int[][] edges, int E, int V) {
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        weight[0] = 0;
        
        for(int i = 0;i < V; i++) {
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex] = true;

            for(int j = 0; j < edges[minVertex].length; j++) {
                if( (edges[i][j] != 0) && (weight[j] > weight[i] + edges[i][j])) {
                    weight[j] = weight[i] + edges[i][j];
                }
            }
        }

        for(int i =0; i < V; i++) {
            System.out.println("Shortest Cost 0 -> " + i + " : " + weight[i]);
        }
    }

    public static int findMinVertex(boolean visited[], int[] weight) {
        int minVertex = -1;
        for(int i = 0; i < weight.length; i++) {
            if(!visited[i] && ( minVertex == -1 || weight[i] < weight[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

}