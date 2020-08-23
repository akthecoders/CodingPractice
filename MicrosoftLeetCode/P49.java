import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Group Anagrams
public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String ss = new String(cs);
            if (map.containsKey(ss)) {
                map.get(ss).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(ss, l);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> val : map.values()) {
            ans.add(new ArrayList<>(val));
        }
        return ans;
    }
}