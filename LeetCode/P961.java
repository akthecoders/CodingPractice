import java.util.HashMap;
import java.util.Map;

//N-Repeated Element in Size 2N Array
public class P961 {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : A) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int required = A.length - map.size() + 1;

        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            if (itr.getValue() == required) {
                return itr.getKey();
            }
        }
        return -1;
    }
}