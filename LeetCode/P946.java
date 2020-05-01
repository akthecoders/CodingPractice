// Validate Stack Sequences
import java.util.Stack;
public class P946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int p = 0;
        int pop = 0;
        int pn = pushed.length;
        int popn = popped.length;
        Stack<Integer> stack = new Stack<>();
        while (p < pn && pop < popn) {
            if (pushed[p] == popped[pop]) {
                stack.push(pushed[p]);
                while (!stack.isEmpty()) {
                    if (stack.peek() == popped[pop]) {
                        stack.pop();
                        pop++;
                    } else {
                        break;
                    }
                }
                p++;
            } else {
                stack.push(pushed[p]);
                p++;
            }
        }

        return stack.isEmpty();
    }
}