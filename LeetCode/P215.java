import java.util.PriorityQueue;

//Kth Largest Element in an Array
public class P215 {
    class Pair implements Comparable<Pair> {
        int d;

        Pair(int d) {
            this.d = d;

        }

        public int compareTo(Pair p) {
            return p.d - this.d;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Pair> pQ = new PriorityQueue<>();
        for (int x : nums) {
            pQ.add(new Pair(x));
        }
        for (int i = 0; i < k - 1; i++) {
            pQ.poll();
        }
        return pQ.poll().d;
    }
}