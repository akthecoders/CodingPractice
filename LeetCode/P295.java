import java.util.Collections;
import java.util.PriorityQueue;

//Find Median from Data Stream
public class P295 {
    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public P295() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.offer(num);
        hi.offer(lo.peek());
        lo.poll();

        if (lo.size() < hi.size()) {
            lo.offer(hi.peek());
            hi.poll();
        }

    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : ((double) lo.peek() + hi.peek()) * 0.5;
    }
}