import java.util.ArrayList;
import java.util.Arrays;

public class printPath {
    public static void main(String[] args) {
        int[][] edges = { {0,1,0,1,0},  {0,0,0,1,0}, {0,0,0,1,0},{0,0,1,0,0},{0,0,0,0,0},};
        printPathTell(edges, 0, 3);
    }

    public static void printPathTell(int[][] edges, int sv, int ev) {
        boolean visited[] = new boolean[edges.length];
        Arrays.fill(visited, false);
        ArrayList<Integer> pathList = new ArrayList<>();
        printPathUtil(edges, sv, ev, pathList, visited);
    }

    public static void printPathUtil(int[][] edges, int sv, int ev, ArrayList<Integer> pathList, boolean visited[]) {
        if(sv == ev) {
            visited[sv] = true;
            pathList.add(sv);
            System.out.println(pathList);
            return;
        }

        visited[sv] = true;
        pathList.add(sv);
        for(int i = 0; i < edges[sv].length; i++) {
            int n = edges[sv][i];
            if(n == 1 && !visited[i]) {
                printPathUtil(edges, i, ev, pathList, visited);
            }
        }

        pathList.remove(sv);
    }
}