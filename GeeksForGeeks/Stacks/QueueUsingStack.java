/**
 * QueueUsingStack
 */
public class QueueUsingStack {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}

class Queue {
    static Stack st1 = new Stack();
    static Stack st2 = new Stack();

    public void enQueue(int x) {
        while(!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        st1.push(x);
        while(!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    public int deQueue() {
        if(st1.isEmpty()) {
            System.out.println("Q is empty");
        }

        int x = st1.peek();
        st1.pop();
        return x;
    }
}