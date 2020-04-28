// Maximum Subarray
public class P53 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int t = 0;

        while (start < nums.length && end < nums.length) {
            t = t + nums[end++];
            result = Math.max(t, result);
            if (t < 0) {
                t = 0;
                start = end;
            }
        }

        return result;
    }
}