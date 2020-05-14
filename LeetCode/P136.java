import java.util.HashMap;
import java.util.Map;

//Single Number
public class P136 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        for (Map.Entry<Integer, Integer> itr : map.entrySet()) {
            if (itr.getValue() == 1)
                return itr.getKey();
        }
        return 0;
    }
}