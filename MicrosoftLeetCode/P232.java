import java.util.Stack;

//Implement Queue using Stacks
public class P232 {
    Stack<Integer> st;

    /** Initialize your data structure here. */
    public P232() {
        st = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        insertAtEnd(x, st);
    }

    public void insertAtEnd(int x, Stack<Integer> st) {
        if (st.size() == 0) {
            st.push(x);
            return;
        }
        int tmp = st.pop();
        insertAtEnd(x, st);
        st.push(tmp);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (st.size() == 0)
            return 0;
        return st.pop();
    }

    /** Get the front element. */
    public int peek() {
        return st.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
    }
}