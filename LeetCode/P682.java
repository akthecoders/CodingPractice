// Baseball Game
import java.util.*;
import java.lang.Character;
public class P682 {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++) {
            int n = ops[i].length();
            if (n > 1 || Character.isDigit(ops[i].charAt(0))) {
                st.push(Integer.parseInt(ops[i]));
            } else {
                if (ops[i].charAt(0) == '+' && st.size() >= 2) {
                    int one = st.pop();
                    int two = st.pop();
                    st.push(two);
                    st.push(one);
                    st.push(one + two);
                } else if (ops[i].charAt(0) == 'D') {
                    int data = st.pop();
                    st.push(data);
                    st.push(data * 2);
                } else if (ops[i].charAt(0) == 'C') {
                    st.pop();
                }
            }
        }

        int res = 0;
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}