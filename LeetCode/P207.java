// Course Schedule

import java.util.*;
public class P207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ArrayList<Integer> hm = graph.get(i);
            if (hm == null) {
                hm = new ArrayList<>();
            }
            graph.put(i, hm);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!bfs(i, visited, stack, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean bfs(Integer v, boolean[] marked, boolean[] onStack, HashMap<Integer, ArrayList<Integer>> graph) {
        if (marked[v])
            return true;

        marked[v] = true;
        onStack[v] = true;
        ArrayList<Integer> lst = graph.get(v);
        for (int j = 0; j < lst.size(); j++) {
            Integer i = (Integer) lst.get(j);
            if (onStack[i]) {
                return false;
            }
            if (!bfs(i, marked, onStack, graph))
                return false;
        }
        onStack[v] = false;
        return true;
    }
}