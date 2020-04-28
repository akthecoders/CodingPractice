// Implement Queue using Stacks
import java.util.*;

public class P232 {
    Stack<Integer> stack;
    int start = 0;

    public P232() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return (int) stack.get(start++);
    }

    public int peek() {
        return (int) stack.get(start);
    }

    public boolean empty() {
        return stack.size() == start + 1 ? false : true;
    }
}