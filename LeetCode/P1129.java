//  Shortest Path with Alternating Colors
import java.util.*;
public class P1129 {
    private final int RED = 1, BLUE = 2;
    
    private class Node{
        int idx, color;
        public Node (int idx, int color){
            this.idx = idx;
            this.color = color;
        }
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        ArrayList<Integer>[] rGraph = buildGraph(red_edges, n);
        ArrayList<Integer>[] bGraph = buildGraph(blue_edges, n);
        
        boolean rVisited[] = new boolean[n];
        Arrays.fill(rVisited, false);
        rVisited[0] = true;
        boolean bVisited[] = new boolean[n];
        Arrays.fill(bVisited, false);
        bVisited[0] = true;
        
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[0] = 0;
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, BLUE));
        q.add(new Node(0, RED));
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node u = q.poll();

                if(u.color == RED) {
                    for(int v: bGraph[u.idx]) {
                        if(!bVisited[v]) {
                            if(distance[v] == -1) {
                                distance[v] = level + 1;
                            }
                            bVisited[v] = true;
                            q.add(new Node(v, BLUE));
                        }
                    }
                }
                else {
                    for(int v: rGraph[u.idx]) {
                        if(!rVisited[v]) {
                            if(distance[v] == -1) {
                                distance[v] = level + 1;
                            }
                            rVisited[v] = true;
                            q.add(new Node(v, RED));
                        }
                    }
                }
            }
            level++;
        }
        return distance;
    }
    
    @SuppressWarnings("unchecked")
    public ArrayList<Integer>[] buildGraph(int[][] edges, int n) {
        ArrayList<Integer>[] res = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++) {
            res[edges[i][0]].add(edges[i][1]);
        }
        return res;
    }
}