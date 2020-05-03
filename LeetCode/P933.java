import java.util.LinkedList;
import java.util.Queue;

// Number of Recent Calls
public class P933 {
    private Queue<Integer> queue;

    public P933() {
        queue = new LinkedList<>();        
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}