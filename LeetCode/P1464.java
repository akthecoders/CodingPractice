import java.util.Arrays;

//Maximum Product of Two Elements in an Array
public class P1464 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0] - 1;
        Arrays.sort(nums);
        int n = nums.length - 1;
        return ((nums[n] - 1) * (nums[n - 1] - 1));
    }
}