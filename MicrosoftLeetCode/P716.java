import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

//Max Stack
public class P716 {
    Stack<Integer> stack;
    PriorityQueue<Integer> pQ;

    /** initialize your data structure here. */
    public P716() {
        stack = new Stack<>();
        pQ = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void push(int x) {
        stack.push(x);
        pQ.add(x);
    }

    public int pop() {
        Integer t = stack.pop();
        pQ.remove(t);
        return t;
    }

    public void removeFromStack(Stack<Integer> stack, int x) {
        if (stack.peek() == x) {
            stack.pop();
            return;
        }
        Integer t = stack.pop();
        removeFromStack(stack, x);
        stack.push(t);
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return pQ.peek();
    }

    public int popMax() {
        Integer x = pQ.remove();
        removeFromStack(stack, x);
        return x;
    }
}