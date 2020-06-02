//Find Minimum in Rotated Sorted Array
public class P153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.min(nums[0], nums[1]);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1])
                continue;
            else
                return nums[i + 1];
        }
        return nums[0];
    }
}