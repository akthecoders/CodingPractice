import java.util.*;

public class BFSAdjMatrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int[][] edges = new int[V][V];
        for(int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }
        printGraph(edges);
        s.close();
	}
    
    public static void printGraph(int[][] edges) {
        boolean visited[] = new boolean[edges.length];
        Arrays.fill(visited, false);
        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                printGraphBFS(i, visited, edges);
            }
        }
    }
    
    public static void printGraphBFS(int sv, boolean[] visited, int[][] edges) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while(!q.isEmpty()) {
            int curr = q.peek();
            q.poll();
            System.out.println(curr);
            for(int i =0; i < edges[curr].length; i++) {
                int n = edges[curr][i];
                if(!visited[i] && n == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}