import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Employee Importance
public class P690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    Map<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e : employees)
            map.put(e.id, e);
        return dfs(id);
    }

    public int dfs(int eid) {
        Employee employee = map.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates) {
            ans += dfs(subid);
        }
        return ans;
    }
}