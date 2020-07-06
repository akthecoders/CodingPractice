import java.util.Stack;

//Longest Valid Parentheses
public class P32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int top = st.peek();
            if (top > -1 && s.charAt(top) == '(' && s.charAt(i) == ')') {
                st.pop();
                max = Math.max(max, i - st.peek());
            } else {
                st.push(i);
            }
        }
        return max;
    }
}