// Tag Validator
import java.util.*;
public class P591 {
    public boolean isValid(String code) {
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < code.length()) {
            if (i > 0 && st.isEmpty())
                return false;
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0)
                    return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9)
                    return false;
                if (st.isEmpty() || !code.substring(j, i++).equals(st.pop()))
                    return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf(">", j);
                if (i < 0 || i == j || i - j > 9)
                    return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k)))
                        return false;
                }
                st.push(code.substring(j, i++));
            } else
                i++;
        }
        return st.isEmpty();
    }
}