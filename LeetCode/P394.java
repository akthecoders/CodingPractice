// Decode String
import java.util.*;
public class P394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String res = "";
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == ']') {
                String t = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    t = stack.pop() + t;
                }
                stack.pop();
                int times = Integer.parseInt(stack.pop());
                String time = "";
                for (int j = 0; j < times; j++) {
                    time += t;
                }
                if (!stack.isEmpty()) {
                    stack.push(time);
                } else {
                    res += time;
                }
            } else {
                if (num > 0) {
                    stack.push(Integer.toString(num));
                    num = 0;
                }
                stack.push(Character.toString(s.charAt(i)));
            }
        }
        String stackLeft = "";
        while (!stack.isEmpty()) {
            stackLeft = stack.pop() + stackLeft;
        }
        return res + stackLeft;
    }
}