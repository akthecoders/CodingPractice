import java.util.ArrayList;
import java.util.List;

//Combinations
public class P77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
         solve(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    public void solve(List<List<Integer>> result, List<Integer> curr, int index, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        if (index > n) {
            return;
        }

        for (int i = index; i <= n; i++) {
            if (curr.size() > 0 && curr.get(curr.size() - 1) == i)
                continue;
            curr.add(i);
            solve(result, curr, i, n, k - 1);
            curr.remove(curr.size() - 1);
        }
    }
}