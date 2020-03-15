/**
 * StackTest
 */
public class StackTest {

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(3);
        st.push(4);
        System.out.println(st.pop() + " popped out of stack");
    }
}