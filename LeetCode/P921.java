// Minimum Add to Make Parentheses Valid
import java.util.*;
public class P921 {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else {
                if (!st.isEmpty() && st.peek() == '(' && s.charAt(i) == ')') {
                    st.pop();
                } else {
                    st.push(s.charAt(i));
                }
            }
        }

        return st.size();
    }
}