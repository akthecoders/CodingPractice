// Combination SumII
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>());
        return res;
    }

    public void dfs(int i, int[] candidates, int target, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0)
            return;
        for (int j = i; j < candidates.length; j++) {
            if (j == i || candidates[j] != candidates[j - 1]) {
                list.add(candidates[j]);
                dfs(j + 1, candidates, target - candidates[j], list);
                list.remove(list.size() - 1);
            }
        }
    }
}