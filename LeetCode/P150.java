// Evaluate Reverse Polish Notation
import java.util.*;
public class P150 {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int d1 = Integer.parseInt(st.pop());
                int d2 = Integer.parseInt(st.pop());
                int op = d2 + d1;
                st.push(Integer.toString(op));
            } else if (str.equals("-")) {
                int d1 = Integer.parseInt(st.pop());
                int d2 = Integer.parseInt(st.pop());
                int op = d2 - d1;
                st.push(Integer.toString(op));
            } else if (str.equals("*")) {
                int d1 = Integer.parseInt(st.pop());
                int d2 = Integer.parseInt(st.pop());
                int op = d2 * d1;
                st.push(Integer.toString(op));
            } else if (str.equals("/")) {
                int d1 = Integer.parseInt(st.pop());
                int d2 = Integer.parseInt(st.pop());
                int op = d2 / d1;
                st.push(Integer.toString(op));
            } else {
                st.push(str);
            }
        }
        return Integer.parseInt(st.peek());
    }
}