import java.util.PriorityQueue;

// Kth Largest Element in a Stream
public class P703 {
    private int K;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public P703(int k, int[] nums) {
        this.K = k;
        for(int a: nums){
            add(a);
        }
        
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > this.K) {
            pq.poll();
        }
        return pq.peek();
    }
}