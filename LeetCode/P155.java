// Min Stack
import java.util.*;
public class P155 {
    class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Node> s;

    /** initialize your data structure here. */
    public P155() {
        s = new Stack<>();
    }

    public void push(int x) {
        s.push(new Node(x, s.size() == 0 ? x : Math.min(x, getMin())));
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().val;
    }

    public int getMin() {
        return s.peek().min;
    }
}