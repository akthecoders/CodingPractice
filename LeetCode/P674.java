//Longest Continuous Increasing Subsequence
public class P674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;
        int longest = 1;
        int curr = 1;
        int left = 0;
        int right = 0;

        while (left < nums.length && right < nums.length) {
            while (right + 1 < nums.length && nums[right] < nums[right + 1]) {
                right++;
            }
            curr = right - left + 1;
            longest = Math.max(longest, curr);
            right++;
            left = right;
        }
        return longest;
    }
}