import java.util.Arrays;

// Maximum Product of Three Numbers
public class P628 {
    public int maximumProduct(int[] nums) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int result = 1;
        int left = 0;
        int right = nums.length - 1;
        int result2 = 1;
        int result3 = 1;
        result *= nums[right] * nums[right - 1] * nums[right - 2];
        result2 *= nums[left] * nums[left + 1] * nums[left + 2];
        result3 *= nums[left] * nums[left + 1] * nums[right];

        return Math.max(result, Math.max(result2, result3));
    }
}