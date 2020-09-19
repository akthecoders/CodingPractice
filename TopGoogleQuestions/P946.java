import java.util.Stack;

// Validate Stack Sequences
public class P946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;
        if (pushed.length == 0)
            return true;

        Stack<Integer> st = new Stack<>();
        int j = 0;
        int N = pushed.length;
        for (int x : pushed) {
            st.push(x);
            while (!st.isEmpty() && j < N && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }
        return j == N;
    }
}
