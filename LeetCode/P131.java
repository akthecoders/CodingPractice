import java.util.ArrayList;
import java.util.List;

//Palindrome Partitioning
public class P131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }

    private void helper(List<List<String>> res, List<String> cur, String s, int lo) {
        if (lo == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        int n = s.length();
        for (int hi = lo; hi < n; hi++) {
            if (isPal(s, lo, hi)) {
                cur.add(s.substring(lo, hi + 1));
                helper(res, cur, s, hi + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int lo, int hi) {
        while (lo <= hi) {
            if (s.charAt(lo) != s.charAt(hi))
                return false;
            lo++;
            hi--;
        }

        return true;
    }
}