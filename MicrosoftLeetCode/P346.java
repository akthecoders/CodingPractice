import java.util.LinkedList;
import java.util.Queue;

//Moving Average from Data Stream
public class P346 {
    Queue<Integer> q;
    int maxCap;
    int currSize;
    int sum;

    /** Initialize your data structure here. */
    public P346(int size) {
        q = new LinkedList<>();
        maxCap = size;
        sum = 0;
        currSize = 0;
    }

    public double next(int val) {
        sum += val;
        q.offer(val);
        currSize++;
        if (currSize > maxCap) {
            sum -= q.poll();
            currSize--;
        }
        return (double) ((double) sum / (double) currSize);
    }
}