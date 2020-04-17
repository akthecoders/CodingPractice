import java.util.Arrays;
import java.util.Scanner;

public class DFSAdjMatrix {
    public static void main(String[] args) {
        int v;
        int e;
        Scanner scan = new Scanner(System.in);
        v = scan.nextInt();
        e = scan.nextInt();

        int edges[][] = new int[v][v];
        for(int i = 0; i < e; i++) {
            int sv = scan.nextInt();
            int ev = scan.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }

        printEdges(edges);
        scan.close();
    }

    public static void printEdges(int[][] edges) {

        boolean visited[] = new boolean[edges.length];
        Arrays.fill(visited, false);

        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                printEdgesUtil(i, visited, edges);
            }
        }
    }

    public static void printEdgesUtil(int sv, boolean[] visited, int [][] edges) {
        visited[sv] = true;
        System.out.println(sv);
        for(int i = 0; i < edges[sv].length; i++) {
            int n = edges[sv][i];
            if(!visited[n]) {
                printEdgesUtil(n, visited, edges);
            }
        }
    }
}