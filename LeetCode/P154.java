import java.util.Arrays;

//Find Minimum in Rotated Sorted Array II
public class P154 {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}