import java.util.HashSet;
import java.util.Set;

//Contains Duplicate
public class P217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums) {
            if(set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}