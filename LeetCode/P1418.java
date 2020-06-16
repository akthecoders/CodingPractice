import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//Display Table of Food Orders in a Restaurant
public class P1418 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<String> set = new TreeSet<>();
        for (List<String> od : orders) {
            int tab = Integer.parseInt(od.get(1));
            String dish = od.get(2);
            map.computeIfAbsent(tab, k -> new HashMap<>());
            map.get(tab).put(dish, map.get(tab).getOrDefault(dish, 0) + 1);
            set.add(dish);
        }
        int len = Collections.max(map.keySet());
        List<String> cap = new ArrayList<>();
        cap.add("Table");
        for (String dish : set)
            cap.add(dish);
        List<List<String>> res = new ArrayList<>();
        res.add(cap);
        for (int i = 0; i <= len; i++) {
            if (!map.containsKey(i))
                continue;
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(i));
            Map<String, Integer> ds = map.get(i);
            for (int j = 1; j < cap.size(); j++) {
                list.add(String.valueOf(ds.getOrDefault(cap.get(j), 0)));
            }
            res.add(list);
        }
        return res;
    }
}