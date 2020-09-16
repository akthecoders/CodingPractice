import java.util.Deque;
import java.util.LinkedList;

//Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
public class P1438 {
    public void addIdxToMax(Deque<Integer> q, int[] nums, int idx) {
        if (idx < nums.length) {
            while (!q.isEmpty() && nums[q.getFirst()] <= nums[idx]) {
                q.removeFirst();
            }
            q.addFirst(idx);
        }
    }

    public void addIdxToMin(Deque<Integer> q, int[] nums, int idx) {
        if (idx < nums.length) {
            while (!q.isEmpty() && nums[q.getFirst()] >= nums[idx]) {
                q.removeFirst();
            }
            q.addFirst(idx);
        }
    }

    public void removeIdx(Deque<Integer> q, int idx) {
        if (q.getLast() == idx) {
            q.removeLast();
        }
    }

    public int longestSubarray(int[] nums, int limit) {
        if (limit < 0) {
            return 0;
        }
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();

        minQ.add(0);
        maxQ.add(0);

        int l = 0;
        int r = 0;

        int max = 1;
        while (r < nums.length) {
            int rMax = nums[maxQ.getLast()];
            int rMin = nums[minQ.getLast()];

            if (Math.abs(rMax - rMin) <= limit) {
                r++;
                max = Math.max(max, r - l);
                addIdxToMin(minQ, nums, r);
                addIdxToMax(maxQ, nums, r);
            } else {
                removeIdx(minQ, l);
                removeIdx(maxQ, l);
                l++;
            }
        }
        return max;
    }
}
