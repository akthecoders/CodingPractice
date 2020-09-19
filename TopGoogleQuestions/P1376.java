import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Time Needed to Inform All Employees
public class P1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            int mn = manager[i];
            int rp = i;
            if (mn == -1)
                continue;

            List<Integer> l = map.get(mn);
            if (l == null)
                l = new ArrayList<>();
            l.add(rp);
            map.put(mn, l);
        }

        HashMap<Integer, Integer> cost = new HashMap<>();
        for (int i = 0; i < informTime.length; i++) {
            int p = i;
            int c = informTime[i];
            cost.put(p, c);
        }
        Set<Integer> visited = new HashSet<>();

        return getCost(map, cost, headID, visited);
    }

    public int getCost(HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> cost, int curr,
            Set<Integer> visited) {
        if (visited.contains(curr))
            return 0;
        visited.add(curr);

        List<Integer> connected = map.get(curr);
        int max = 0;
        if (connected != null) {
            for (Integer c : connected) {
                max = Math.max(max, getCost(map, cost, c, visited));
            }
        }

        visited.remove(curr);
        return cost.get(curr) + max;
    }
}
