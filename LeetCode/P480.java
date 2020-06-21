import java.util.Collections;
import java.util.PriorityQueue;

//Sliding Window Median
public class P480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        int lengthOfMedianArray = nums.length - (k - 1);

        // window size is greater than array size
        if (lengthOfMedianArray <= 0) {
            return new double[0];
        }

        double[] resultArray = new double[lengthOfMedianArray];
        int left = 0, right = 0;

        // Slide window till the end.
        while (right < nums.length) {
            int num = nums[right];

            // Add to max Queue.
            maxQueue.offer(num);

            // Remove from max Queue and add to max Queue.
            minQueue.offer(maxQueue.poll());

            // if min queue is getting bigger, Need to remove lowest element from min queue
            // and add to max queue.
            if (maxQueue.size() < minQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }

            // if we have reached the window size, time to get a median.
            if ((right - left + 1) == k) {
                // Calcuate Median.
                double subArrayMedian = 0d;
                if (k % 2 == 0) {
                    // doing (a/2 + b/2) as to reduce the large numbers instead of (a+b)/2.
                    subArrayMedian = (maxQueue.peek() * 0.5) + (minQueue.peek() * 0.5);
                } else {
                    subArrayMedian = maxQueue.peek();
                }
                resultArray[left] = subArrayMedian;

                // Remove the element
                int elementToBeRemoved = nums[left];

                // Check both queues and remove the element from
                // where it is present
                if (!maxQueue.remove(elementToBeRemoved)) {
                    minQueue.remove(elementToBeRemoved);
                }
                left++;
            }
            right++;
        }
        return resultArray;
    }
}