import java.util.PriorityQueue;
import java.util.Stack;

//Min Stack
public class P155 {
    Stack<Integer> stack;
    PriorityQueue<Integer> pQ;

    /** initialize your data structure here. */
    public P155() {
        stack = new Stack<>();
        pQ = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        pQ.add(x);
    }

    public void pop() {
        Integer t = stack.pop();
        pQ.remove(t);
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

    public int getMin() {
        return pQ.peek();
    }
}