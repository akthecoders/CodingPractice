import java.util.Stack;

public class SortAStack {
    public static void main(String args[]) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(2);
        st.push(5);
        st.push(4);

        sort(st);

        while(!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }

    public static void sort(Stack<Integer> st) {
        if(st.size() == 0) return;

        int tmp = st.pop();
        sort(st);
        insert(st, tmp);
    }

    public static void insert(Stack<Integer> st, int tmp) {
        if(st.size() == 0 || st.peek() <= tmp) {
            st.push(tmp);
            return;
        }
        int t = st.pop();
        insert(st, tmp);
        st.push(t);
    } 
}