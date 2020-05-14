import java.util.HashMap;
import java.util.Map;

//Find Lucky Integer in an Array
public class P1394 {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            int digit = itr.getKey();
            int freq = itr.getValue();
            if (freq == digit) {
                max = Math.max(max, digit);
            }
        }
        return max;
    }
}