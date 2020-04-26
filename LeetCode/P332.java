// Reconstruct Itinerary
import java.util.*;
public class P332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();

        for (List<String> l : tickets) {
            if (map.containsKey(l.get(0))) {
                map.get(l.get(0)).add(l.get(1));
            } else {
                List<String> ls = new ArrayList<String>();
                ls.add(l.get(1));
                map.put(l.get(0), ls);
            }
        }

        for (List<String> l : map.values()) {
            Collections.sort(l);
        }

        List<String> res = new ArrayList<String>();
        dfs("JFK", res, map);
        Collections.reverse(res);
        return res;
    }

    public void dfs(String str, List<String> res, Map<String, List<String>> map) {
        if (map.get(str) == null) {
            res.add(str);
            return;
        }
        Iterator<String> itr = map.get(str).iterator();
        while (itr.hasNext()) {
            String next = itr.next();
            itr.remove();
            dfs(next, res, map);
        }
        res.add(str);
    }
}