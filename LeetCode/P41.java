//First Missing Positive
public class P41 {
    public int firstMissingPositive(int[] nums) {
        int curr, temp;
        if (nums.length < 1)
            return 1;

        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if (curr != i + 1 && curr > 0 && curr <= nums.length) {
                while (curr > 0 && curr <= nums.length && nums[curr - 1] != curr) {
                    temp = nums[curr - 1];
                    nums[curr - 1] = curr;
                    curr = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}