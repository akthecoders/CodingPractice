import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Find All Duplicates in an Array
public class P442 {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1)
            return result;
        if (nums.length == 2) {
            if (nums[0] == nums[1]) {
                result.add(nums[0]);
                return result;
            }
        }
        int prev = 0;
        for (int x : nums) {
            if (prev == x) {
                result.add(x);
            } else {
                prev = x;
            }
        }
        return result;
    }
}