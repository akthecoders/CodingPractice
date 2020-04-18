import java.util.Arrays;

public class hasPath {
    public static void main(String[] args) {
    	int[][] edges = { {0,1,0,1,0},  {0,0,0,1,0}, {0,0,0,1,0},{0,0,1,0,0},{0,0,0,0,0},};
        if(hasPathTell(edges, 0, 4)) {
            System.out.println("Path Exist");
        }
        else {
            System.out.println("Path does not exist");
        }
    }

    public static boolean hasPathTell(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length];
        Arrays.fill(visited, false);

        for(int i = 0; i < edges[sv].length; i++) {
            int n = edges[sv][i];
            if(n == 1 && !visited[i]) {
                return hasPathUtil(edges, n, ev, visited);
            }
        }
        return false;
    }

    public static boolean hasPathUtil(int[][] edges, int sv, int ev, boolean[] visited) {
        if(sv == ev) {
            return true;
        }
        visited[sv] = true;
        
        for(int i = 0; i < edges[sv].length; i++) {
            int n = edges[sv][i];
            if(!visited[i] && n == 1) {
                return hasPathUtil(edges, i, ev, visited);
            }
        }
        return false;
    }

}