import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Employee Importance
public class P690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0)
            return 0;
        if (employees.size() == 1)
            return employees.get(0).importance;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> cost = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (Employee e : employees) {
            cost.put(e.id, e.importance);
            for (Integer conn : e.subordinates) {
                List<Integer> list = map.get(e.id);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(conn);
                map.put(e.id, list);
            }
        }

        return dfs(map, cost, visited, id);
    }

    public int dfs(HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> cost, Set<Integer> visited, int id) {
        if (visited.contains(id)) {
            return 0;
        }

        visited.add(id);
        int res = cost.get(id);
        List<Integer> list = map.get(id);
        if (list != null) {
            for (Integer l : list) {
                res += dfs(map, cost, visited, l);
            }
        }
        visited.remove(id);
        return res;
    }
}
