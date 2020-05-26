import java.util.ArrayList;
import java.util.List;

//Combination Sum
public class P39 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, 0, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int currSum, int target, int start, ArrayList<Integer> list) {
        if (start == candidates.length || currSum >= target) {
            if (currSum == target) {
                result.add(new ArrayList<>(list));
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            list.add(val);
            helper(candidates, currSum + val, target, i, list);
            list.remove(list.size() - 1);
        }
    }
}