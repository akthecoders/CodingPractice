import java.util.HashMap;
import java.util.Map;

// Majority Element
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int res = 0;
        int num = 0;
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            if (itr.getValue() > res) {
                num = itr.getKey();
                res = itr.getValue();
            }
        }
        return num;
    }
}