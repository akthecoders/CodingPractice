import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//Combination Sum
public class P39 {
    List<List<Integer>> result;
    HashSet<String> set;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        set = new HashSet<>();
        solver(candidates, target, 0, new ArrayList<>(), 0);
        return result;
    }

    public void solver(int[] candidates, int target, int sum, List<Integer> currVals, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(currVals));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int currNum = candidates[i];
            if (sum + currNum <= target && currNum != 0) {
                currVals.add(currNum);
                solver(candidates, target, sum + currNum, currVals, i);
                currVals.remove(currVals.size() - 1);
            }
        }
    }
}