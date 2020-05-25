import java.util.ArrayList;
import java.util.List;

//Combination Sum III
public class P213 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        makeComb(1, n, new ArrayList<Integer>(), k, res);
        return res;
    }

    public void makeComb(int currNum, int remain, List<Integer> comb, int k, List<List<Integer>> results) {
        if (remain == 0 && comb.size() == k) {
            results.add(comb);
        } else if (remain >= currNum) {
            for (int i = currNum; i <= 9; i++) {
                List<Integer> copy = new ArrayList<>(comb);
                copy.add(i);
                makeComb(i + 1, remain - i, copy, k, results);
            }
        }
    }
}