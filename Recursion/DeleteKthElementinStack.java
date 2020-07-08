import java.util.Stack;

public class DeleteKthElementinStack {
    public static void main(String args[]) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        
        delete(st, 2);

        while(!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }

    public static void delete(Stack<Integer> st, int k) {
        if(k == 1) {
            st.pop();
            return;
        }
        int tmp = st.pop();
        delete(st, k - 1);
        st.push(tmp);
    }
}