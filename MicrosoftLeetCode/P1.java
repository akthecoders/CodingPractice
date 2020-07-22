import java.util.HashMap;

//Two Sum
public class P1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0)
            return new int[] {};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                map.put(num, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int required = target - x;
            if (map.containsKey(required)) {
                Integer key = map.get(required);
                if (key != i)
                    return new int[] { i, map.get(required) };
            }
        }
        return new int[] {};
    }
}