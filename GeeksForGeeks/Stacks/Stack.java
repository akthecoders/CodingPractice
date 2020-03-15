/**
 * Stack
 */
public class Stack {
    static final int MAX = 1000;
    int top;
    int sa[] = new int[MAX];
    
    boolean isEmpty() {
        return (top < 0);
    }

    Stack() {
        top = -1;
    }

    boolean push(int data) {
        if(top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        
        sa[++top] = data;
        System.out.println(data + " pushed to stack");
        return true;
    }

    int pop() {
        if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = sa[top--];
            return x;
        }
    }

    int peek() {
        if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int x = sa[top];
            return x;
        }
    }
}