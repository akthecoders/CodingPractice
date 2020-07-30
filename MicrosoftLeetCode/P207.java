//Course Schedule
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int[] relation = prerequisites[i];
            List<Integer> list = map.getOrDefault(relation[1], new ArrayList<>());
            list.add(relation[0]);
            map.put(relation[1], list);
        }

        Map<Integer, Boolean> visited = new HashMap<>();
        for (int currCourse = 0; currCourse < numCourses; ++currCourse) {
            if (!dfs(map, visited, currCourse)) {
                return false;
            }
        }
        return true;
    }

    
    public boolean dfs(Map<Integer, List<Integer>> map, Map<Integer, Boolean> visited, int key) {
        List<Integer> list = map.getOrDefault(key, new ArrayList<>());
        if (visited.containsKey(key) && visited.get(key)) {
            return false;
        }

        if (!map.containsKey(key)) {
            return true;
        }

        visited.put(key, true);
        boolean ret = true;
        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            ret = dfs(map, visited, curr);
            if (!ret)
                break;
        }

        visited.put(key, false);
        return ret;
    }
}