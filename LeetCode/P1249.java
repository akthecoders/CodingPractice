//  Minimum Remove to Make Valid Parentheses
import java.util.Stack;
public class P1249 {
    class Wrap {
        char val;
        int index;

        Wrap(char v, int i) {
            this.val = v;
            this.index = i;
        }
    }

    public String minRemoveToMakeValid(String s) {
        Stack<Wrap> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(new Wrap('(', i));
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek().val == '(') {
                    st.pop();
                } else {
                    st.push(new Wrap(')', i));
                }
            }
        }

        while (!st.isEmpty()) {
            int index = st.pop().index;
            s = s.substring(0, index) + s.substring(index + 1);
        }

        return s;
    }
}