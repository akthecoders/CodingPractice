import java.util.*;

public class LevelOfEachNode {
    public static void main(String[] args) {
        int V = 8;
        Vector<Vector<Integer>> graph = new Vector<>();
        for (int i = 0; i < V; i++) {
            graph.add(new Vector<Integer>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(1).add(5);
        graph.get(2).add(5);
        graph.get(2).add(6);
        graph.get(6).add(7);

        printLevels(graph, V, 0);
    }

    public static void printLevels(Vector<Vector<Integer>> graph, int V, int start) {
        int level[] = new int[V];
        boolean visited[] = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        level[start] = 0;
        visited[start] = true;

        while (!q.isEmpty()) {
            start = q.peek();
            q.remove();

            for (int i = 0; i < graph.get(start).size(); i++) {
                int b = graph.get(start).get(i);

                level[b] = level[start] + 1;
                visited[b] = true;
                q.add(b);
            }
        }
        System.out.println("Nodes" + " " + "Level");
        for (int i = 0; i < V; i++)
            System.out.println(" " + i + " --> " + level[i]);
    }

}