import java.util.ArrayList;
import java.util.List;

//Generate Parentheses
public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(ans, "", 0, 0, n);
        return ans;
    }

    public void solve(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            solve(ans, cur + "(", open + 1, close, max);

        if (close < open)
            solve(ans, cur + ")", open, close + 1, max);
    }
}