//Maximum Product Subarray
public class P152 {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int mx = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            int mi = Math.min(nums[i], Math.min(nums[i] * max, nums[i] * min));
            max = mx;
            min = mi;
            res = Math.max(res, Math.max(mx, mi));
        }
        return res;
    }
}