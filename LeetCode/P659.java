import java.util.HashMap;

//Split Array into Consecutive Subsequences
public class P659 {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> FM = new HashMap<>();
        HashMap<Integer, Integer> SM = new HashMap<>();

        for (int x : nums)
            FM.put(x, FM.getOrDefault(x, 0) + 1);

        for (int x : nums) {
            if (FM.get(x) == 0) {
                continue;
            }

            if (SM.getOrDefault(x, 0) > 0) {
                SM.put(x, SM.get(x) - 1);
                SM.put(x + 1, SM.getOrDefault(x + 1, 0) + 1);
                FM.put(x, FM.get(x) - 1);
            } else if (FM.getOrDefault(x, 0) > 0 && FM.getOrDefault(x + 1, 0) > 0 && FM.getOrDefault(x + 2, 0) > 0) {
                FM.put(x, FM.get(x) - 1);
                FM.put(x + 1, FM.get(x + 1) - 1);
                FM.put(x + 2, FM.get(x + 2) - 1);
                SM.put(x + 3, SM.getOrDefault(x + 3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    }
}