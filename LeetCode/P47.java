import java.util.ArrayList;
import java.util.List;

//Permutations II
public class P47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        helper(used, list, ans, nums);
        return ans;
    }

    public void helper(boolean used[], List<Integer> list, List<List<Integer>> ans, int[] nums) {
        if (list.size() == nums.length) {
            if (!ans.contains(list)) {
                ans.add(new ArrayList<>(list));
                return;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                list.add(nums[i]);
                helper(used, list, ans, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
}