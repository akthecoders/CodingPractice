// Backspace String Compare
import java.util.*;
public class P844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(S.charAt(i));
            }
        }
        String str1 = "";
        while (!st.isEmpty()) {
            str1 += st.pop();
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!st.isEmpty())
                    st.pop();
            } else {
                st.push(T.charAt(i));
            }
        }
        String str2 = "";
        while (!st.isEmpty()) {
            str2 += st.pop();
        }

        System.out.println("str " + str1 + " " + str2);
        return str1.equals(str2);
    }
}