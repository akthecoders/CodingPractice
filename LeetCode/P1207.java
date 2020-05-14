//Unique Number of Occurrences
import java.util.HashMap;
import java.util.Map;

public class P1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(Map.Entry<Integer, Integer> itr: map.entrySet()) freq.put(itr.getValue() , freq.getOrDefault(itr.getValue(), 0) + 1);
        return freq.size() == map.size() ? true : false;
    }
}