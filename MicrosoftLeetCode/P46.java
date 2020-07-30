import java.util.ArrayList;
import java.util.List;

//Permutations
public class P46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        solver(nums, 0);
        return result;
    }

    public void solver(int[] nums, int len) {
        if (len == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int x : nums) {
                list.add(x);
            }
            result.add(list);
            return;
        }

        for (int i = len; i < nums.length; i++) {
            this.swap(nums, len, i);
            solver(nums, len + 1);
            this.swap(nums, len, i);
        }
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}