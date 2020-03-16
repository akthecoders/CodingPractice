/**
 * TwoStack
 */
public class TwoStack {

    int[] stack = new int[1000];
    int ptr1 = -1;
    int ptr2 = 1000;

    public void push1(int x) {
        if(ptr1 >= ptr2) {
            System.out.println("Stack 2 overflow!");
            return;
        }
        stack[++ptr1] = x;
        System.out.println( x + " pushed in stack 1");
    }
    
    public void push2(int x) {
        if(ptr2 <= ptr1) {
            System.out.println("Stack 2 overflow!");
            return;
        }
        stack[--ptr2] = x;
        System.out.println( x + " pushed in stack 2");
    }

    public int pop1() {
        if(ptr1 < 0) {
            System.out.println("Stack 1 underflow");
            return 0;
        }
        int x = stack[ptr1--];
        System.out.println( x + " popped from stack 1");
        return x;
    }

    public int pop2() {
        if(ptr2 > 999) {
            System.out.println("Stack 2 underflow");
            return 0;
        }
        int x = stack[ptr2++];
        System.out.println(x + " popped from stack 2");
        return x;
    }

    public static void main(String[] args) {
        TwoStack st = new TwoStack();
        st.push1(1);
        st.push2(2);
        
        st.pop2();
        st.pop1();

        st.pop1();
        st.pop2();
    }

}