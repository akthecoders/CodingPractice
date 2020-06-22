import java.util.ArrayList;
import java.util.List;

// Permutations
public class P46 {
    List<List<Integer>> ret;

    public List<List<Integer>> permute(int[] nums) {
        ret = new ArrayList<>();
        helper(0, nums);
        return ret;
    }

    public void helper(int startIndex, int[] nums) {
        if (startIndex == nums.length - 1) {
            List<Integer> lst = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                lst.add(nums[i]);
            }
            ret.add(new ArrayList<>(lst));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            swap(nums, startIndex, i);
            helper(startIndex + 1, nums);
            swap(nums, startIndex, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}