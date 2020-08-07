import java.util.Collections;
import java.util.PriorityQueue;

//Kth Largest Element in an Array
public class P215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        if (k > nums.length)
            return 0;
        if (k <= 0)
            return 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : nums)
            pQ.offer(x);

        for (int i = 1; i < k; i++) {
            pQ.poll();
        }
        return pQ.poll();
    }
}