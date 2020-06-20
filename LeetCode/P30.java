import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Substring with Concatenation of All Words
public class P30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length < 1)
            return res;
        Map<String, Integer> map = new HashMap<>();
        for (String key : words) {
            int val = map.getOrDefault(key, 0) + 1;
            map.put(key, val);
        }
        int step = words[0].length();
        int n = words.length;
        int l = step * n;
        for (int start = 0; start < s.length() - l + 1; start++) {
            Map<String, Integer> tmp = build(s, start, step, n);
            boolean flag = compare(map, tmp);
            if (flag) {
                res.add(start);
            }
        }
        return res;
    }

    private Map<String, Integer> build(String s, int start, int step, int n) {

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int head = start + i * step;
            int tail = head + step;

            String key = s.substring(head, tail);
            int val = map.getOrDefault(key, 0) + 1;

            map.put(key, val);
        }

        return map;
    }

    private boolean compare(Map<String, Integer> map1, Map<String, Integer> map2) {
        for (String key : map1.keySet()) {
            if (!map2.containsKey(key) || map1.get(key) != map2.get(key)) {
                return false;
            }
        }
        return true;
    }
}