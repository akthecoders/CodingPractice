// Reverse Substrings Between Each Pair of Parentheses
import java.util.*;
public class P1190 {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    q.add(st.pop());
                }
                st.pop();
                while (!q.isEmpty()) {
                    st.push(q.poll());
                }
            } else {
                st.push(s.charAt(i));
            }
        }

        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }

        return res;
    }
}