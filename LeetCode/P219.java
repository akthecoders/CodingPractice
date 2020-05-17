import java.util.HashMap;
import java.util.Map;

//Contains Duplicate II
public class P219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer pos = map.get(nums[i]);
            if (pos != null && nums[pos] == nums[i] && i - pos <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}