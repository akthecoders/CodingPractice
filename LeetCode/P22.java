import java.util.ArrayList;
import java.util.List;

//Generate Parentheses
public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String curr, int open, int close, int max) {
        if (curr.length() == 2 * max) {
            list.add(curr);
            return;
        }

        if (open < max) {
            backtrack(list, curr + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(list, curr + ")", open, close + 1, max);
        }
    }
}