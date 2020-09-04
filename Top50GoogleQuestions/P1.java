import java.util.HashMap;

//Two Sum
public class P1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int required = target - num;

            if (map.containsKey(required)) {
                int indexGot = map.get(required);
                if (indexGot != i) {
                    result[0] = i;
                    result[1] = indexGot;
                    return result;
                }
            }
        }

        return result;
    }
}
