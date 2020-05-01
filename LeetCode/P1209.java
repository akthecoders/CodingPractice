// Remove All Adjacent Duplicates in String II
import java.util.*;
public class P1209 {
    class Pair {
        char val;
        int count;

        public Pair(char val) {
            this.val = val;
            this.count = 1;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().val != c) {
                stack.push(new Pair(c));
            } else {
                stack.peek().count += 1;
            }

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.val);
            }
        }

        return sb.reverse().toString();
    }
}