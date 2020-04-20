import java.util.Arrays;
import java.util.Scanner;

public class Prims {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int[][] edges = new int[V][V];
        for(int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            int weight = s.nextInt();

            edges[sv][ev] = weight;
            edges[ev][sv] = weight;
        }
        primsMST(edges, E, V);
        s.close();
    }

    public static void primsMST(int[][] edges, int E, int V) {
        int[] weight = new int[V];
        Arrays.fill(weight, Integer.MAX_VALUE);
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        weight[0] = 0;
        int[] parent = new int[V];
        parent[0] = -1;
        for(int i = 0; i < V; i++) {
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex] = true;
            for(int j = 0; j < edges[minVertex].length;j++) {
                if(edges[minVertex][j] != 0 && !visited[j]) {
                    if(edges[minVertex][j] < weight[j]) {
                        weight[j] = edges[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }
        
        for(int i = 0; i < V; i++) {
            if(parent[i] < i) {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
            else {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
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