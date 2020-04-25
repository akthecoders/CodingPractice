
//Course Schedule II
import java.util.*;

public class P210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

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
        int res[] = new int[numCourses];
        int empty[] = {};
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (!bfs(i, visited, stack, st, graph)) {
                    return empty;
                }
            }
        }

        int index = numCourses - 1;
        while (!st.empty()) {
            res[index--] = st.pop();
        }
        return res;
    }

    public boolean bfs(int v, boolean[] marked, boolean[] onStack, Stack<Integer> st,
            HashMap<Integer, ArrayList<Integer>> graph) {
        if (marked[v]) {
            return true;
        }

        marked[v] = true;
        onStack[v] = true;
        ArrayList<Integer> lst = graph.get(v);
        for (int j = 0; j < lst.size(); j++) {
            Integer i = (Integer) lst.get(j);
            if (onStack[i]) {
                return false;
            }
            if (!bfs(i, marked, onStack, st, graph))
                return false;
        }
        onStack[v] = false;
        st.push(v);
        return true;
    }
}