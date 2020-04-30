
// Implement Stack using Queue.
import java.util.*;

public class P255 {
    Queue<Integer> q;
    Queue<Integer> t;

    /** Initialize your data structure here. */
    public P255() {
        q = new LinkedList<>();
        t = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!q.isEmpty()) {
            t.add(q.poll());
        }
        q.add(x);
        while (!t.isEmpty()) {
            q.add(t.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}