import java.util.HashMap;

//Two Sum
public class P1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        }
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (set.containsKey(target - x) && set.get(target - x) != i) {
                result[0] = set.get(target - x);
                result[1] = i;
                return result;
            }
        }
        return result;
    }
}