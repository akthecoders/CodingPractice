import java.util.ArrayDeque;
import java.util.Deque;

//Basic Calculator II
// Revised
public class P227 {
    public int calculate(String s) {
        String ns = s.replaceAll("\\s+", "");
        Deque<Integer> stack = new ArrayDeque<>();

        char sign = '+';
        for (int i = 0; i < ns.length(); i++) {
            char c = ns.charAt(i);
            if (!Character.isDigit(c)) {
                sign = c;
                continue;
            }

            int val = 0;
            int j = i;
            while (j < ns.length() && Character.isDigit(ns.charAt(j))) {
                val *= 10;
                int currVal = ns.charAt(j) - '0';
                val += currVal;
                j++;
            }

            i = j - 1;

            if (sign == '-') {
                stack.push(val * -1);
            } else if (sign == '+') {
                stack.push(val);
            } else if (sign == '/') {
                int curr = stack.pop();
                stack.push(curr / val);
            } else if (sign == '*') {
                int curr = stack.pop();
                stack.push(val * curr);
            }
        }
        int val = 0;
        while (!stack.isEmpty())
            val += stack.pop();

        return val;
    }
}
