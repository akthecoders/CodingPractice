//Minimum Size Subarray Sum
public class P209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (left < nums.length && right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                len = Math.min(len, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;

        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}