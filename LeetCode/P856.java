
// Score of Parentheses
import java.util.*;

public class P856 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                st.push(score);
                score = 0;
            } else {
                score = st.pop() + Math.max(2 * score, 1);
            }
        }

        return score;
    }
}