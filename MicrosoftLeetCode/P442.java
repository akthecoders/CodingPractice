import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Find All Duplicates in an Array
public class P442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                ans.add(num);
            } else {
                seen.add(num);
            }
        }

        return ans;
    }
}