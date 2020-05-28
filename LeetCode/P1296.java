import java.util.Arrays;
import java.util.TreeMap;

//Divide Array in Sets of K Consecutive Numbers
public class P1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        if (nums.length % k != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int x : nums)
            map.put(x, map.getOrDefault(x, 0) + 1);
        boolean flag = true;
        while (!map.isEmpty()) {
            int smallest = map.firstKey();
            for (int i = 0; i < k; i++) {
                int temp = smallest + i;
                if (!map.containsKey(temp))
                    return false;
                map.put(temp, map.get(temp) - 1);
                if (map.get(temp) == 0)
                    map.remove(temp);
            }
        }

        return flag;
    }
}