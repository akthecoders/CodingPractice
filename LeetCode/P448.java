import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Find All Numbers Disappeared in an Array
public class P448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            set.add(nums[i]);
        for (int i = 1; i <= nums.length; i++)
            if (!set.contains(i))
                result.add(i);
        return result;
    }
}