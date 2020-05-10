import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Minimum Time to Collect All Apples in a Tree
public class P1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(edges, graph);
        Set<Integer> visited = new HashSet<>();
        return helper(0, graph, hasApple, visited);
    }

    public int helper(int node, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited) {
        visited.add(node);
        int res = 0;
        for (int child : graph.getOrDefault(node, new LinkedList<>())) {
            if (!visited.contains(child)) {
                res += helper(child, graph, hasApple, visited);
            }
        }
        if ((res > 0 || hasApple.get(node)) && node != 0)
            res += 2;
        return res;
    }

    public void buildGraph(int[][] edges, Map<Integer, List<Integer>> graph) {
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.putIfAbsent(a, new LinkedList<>());
            graph.putIfAbsent(b, new LinkedList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }
}