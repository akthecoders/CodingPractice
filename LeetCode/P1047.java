// Remove All Adjacent Duplicates In String

import java.util.*;

public class P1047 {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (i < S.length() && !st.isEmpty() && S.charAt(i) == st.peek()) {
                while (i < S.length() && !st.isEmpty() && S.charAt(i) == st.peek()) {
                    i++;
                    st.pop();
                }
                i--;
            } else {
                st.push(S.charAt(i));
            }
        }

        StringBuilder input1 = new StringBuilder();

        while (!st.isEmpty()) {
            input1.append(st.peek());
            st.pop();
        }
        input1 = input1.reverse();
        return input1.toString();
    }
}