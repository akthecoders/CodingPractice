import java.util.ArrayDeque;

//Design Bounded Blocking Queue
public class P1188 {
    ArrayDeque<Integer> deque;
    int cap;

    public P1188(int capacity) {
        deque = new ArrayDeque<>();
        this.cap = capacity;
    }

    public synchronized void enqueue(int element) throws InterruptedException {
        while (deque.size() == this.cap) {
            wait();
        }
        deque.offerFirst(element);
        notifyAll();
    }

    public synchronized int dequeue() throws InterruptedException {
        while (deque.size() == 0) {
            wait();
        }
        int last = deque.pollLast();
        notifyAll();
        return last;
    }

    public int size() {
        return deque.size();
    }
}