//Maximum Average Subarray I
public class P643 {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k)
            return 0d;
        if (nums.length == 1)
            return nums[0];
        int left = 0;
        int right = 0;
        double average = Integer.MIN_VALUE;
        double currSum = 0d;
        double currAvg = 0d;
        int n = nums.length;
        while (left < n && right < n) {
            currSum += nums[right];
            if (right - left + 1 >= k) {
                currAvg = currSum / k;
                average = Math.max(average, currAvg);
                currSum -= nums[left];
                left++;
            }
            right++;
        }
        return average;
    }
}