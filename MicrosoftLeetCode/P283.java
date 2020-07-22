/**
 * P283 Move Zeroes
 */
public class P283 {

    public void moveZeroes(int[] nums) {
        int zeros = 0;
        for (int x : nums)
            if (x == 0)
                zeros++;

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        while (zeros > 0) {
            nums[index] = 0;
            index++;
            zeros--;
        }
    }
}