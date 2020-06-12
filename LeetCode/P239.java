import java.util.ArrayDeque;

//Sliding Window Maximum
public class P239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] output = new int[nums.length - k + 1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!ad.isEmpty() && ad.peekFirst() == i - k) {
                ad.removeFirst();
            }

            while (!ad.isEmpty() && nums[ad.peekLast()] < nums[i]) {
                ad.removeLast();
            }

            ad.offer(i);
            if (i + 1 >= k) {
                output[i + 1 - k] = nums[ad.peekFirst()];
            }
        }
        return output;
    }
}