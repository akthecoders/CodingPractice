//Single Element in a Sorted Array

public class SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i + 1] != nums[i]) {
                return nums[i];
            } else if (i == nums.length - 1 && nums[i - 1] != nums[nums.length - 1]) {
                return nums[nums.length - 1];
            } else if (i > 0 && i < nums.length && nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }
}