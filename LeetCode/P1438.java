// Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
public class P1438 {
    public int longestSubarray(int[] nums, int limit) {
        int i = 0;
        int j = 0;
        int res = 0;
        int min = nums[0];
        int max = nums[0];

        while (j < nums.length) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
            if (Math.abs(max - min) <= limit) {
                res = Math.max(res, j - i + 1);
            } else {
                i++;
                while (i > 0 && nums[i - 1] == nums[i])
                    i++;
                min = nums[i];
                max = nums[i];
                j = i;
            }
            j++;
        }
        return res;
    }
}