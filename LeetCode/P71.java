// Simplify Path
import java.util.*;
public class P71 {
    public String simplifyPath(String path) {
        String[] splitted = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String x : splitted) {
            if (!x.isEmpty()) {
                if (x.equals(".")) {
                    continue;
                } else if (x.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(x);
                }
            }
        }
        String result = "";
        int size = stack.size();
        if (size == 0) {
            return "/";
        }
        for (int i = 0; i < size; i++) {
            result = "/" + stack.pop() + result;
        }

        return result;
    }
}