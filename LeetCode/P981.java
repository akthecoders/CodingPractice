import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Time Based Key-Value Store
public class P981 {
    Map<String, TreeMap<Integer, String>> M;

    public P981() {
        M = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!M.containsKey(key))
            M.put(key, new TreeMap<>());

        M.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!M.containsKey(key))
            return "";

        TreeMap<Integer, String> tree = M.get(key);
        Integer t = tree.floorKey(timestamp);
        return t != null ? tree.get(t) : "";
    }
}