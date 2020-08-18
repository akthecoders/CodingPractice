import java.util.Deque;
import java.util.LinkedList;

//Design Hit Counter
public class P362 {
    class Item {
        public int timestamp;
        public int count;

        Item(int timestamp, int count) {
            this.timestamp = timestamp;
            this.count = count;
        }
    }

    private static final int LIMIT = 300;
    private final Deque<Item> queue;
    private int hits;

    /** Initialize your data structure here. */
    public P362() {
        queue = new LinkedList<>();
        hits = 0;
    }

    public void hit(int timestamp) {
        // there is a possibility that 'getHits' will be never called
        // so we just make sure the queue will not grow infinitely
        cleanup(timestamp);
        if (!queue.isEmpty() && queue.getLast().timestamp == timestamp)
            queue.getLast().count++;
        else
            queue.add(new Item(timestamp, 1));
        hits++;
    }

    public int getHits(int timestamp) {
        cleanup(timestamp);
        return hits;
    }

    private void cleanup(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek().timestamp >= LIMIT)
            hits -= queue.pop().count;
    }
}