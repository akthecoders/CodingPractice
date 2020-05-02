// Check If Word Is Valid After Substitutions
import java.util.*;
public class P1003 {
    class Pair {
        char curr;
        char prev;

        Pair(char c, char p) {
            this.curr = c;
            this.prev = p;
        }
    }

    public boolean isValid(String S) {
        if (S.length() < 3)
            return false;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(S.charAt(0), 'z'));
        st.push(new Pair(S.charAt(1), S.charAt(0)));

        for (int i = 2; i < S.length(); i++) {
            if (!st.isEmpty() && S.charAt(i) == 'c' && st.peek().curr == 'b' && st.peek().prev == 'a') {
                st.pop();
                st.pop();
            } else {
                st.push(new Pair(S.charAt(i), !st.isEmpty() ? st.peek().curr : 'z'));
            }
        }
        return st.isEmpty();
    }
}