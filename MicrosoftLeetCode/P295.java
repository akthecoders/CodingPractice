import java.util.Collections;
import java.util.PriorityQueue;

//Find Median from Data Stream
public class P295 {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public P295() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (max.isEmpty() || max.peek() > num) {
            max.add(num);
        } else {
            min.add(num);
        }

        if (max.size() > min.size() && max.size() - min.size() > 1) {
            while (!(max.size() == min.size() || max.size() + 1 == min.size())) {
                min.add(max.poll());
            }
        } else if (min.size() > max.size() && min.size() - max.size() > 1) {
            while (!(min.size() == max.size() || min.size() + 1 == max.size())) {
                max.add(min.poll());
            }
        }
    }

    public double findMedian() {
        if (max.size() > min.size()) {
            return max.peek();
        } else if (min.size() > max.size()) {
            return min.peek();
        } else {
            return (double) ((double) (min.peek() + max.peek()) / (double) 2);
        }
    }
}