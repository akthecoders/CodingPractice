//Search Insert Position
public class P35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        if (nums[0] >= target)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }
}