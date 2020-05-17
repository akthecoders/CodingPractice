// Search Insert Position
public class P35 {
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (i == 0 && nums[i] > target) {
                return i;
            } else if (i == nums.length - 1 && nums[i] != target) {
                return i + 1;
            } else if (nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }
        return index;
    }
}