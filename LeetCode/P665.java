//Non-decreasing Array
public class P665 {
    public boolean checkPossibility(int[] nums) {
        int p = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (p != -1)
                    return false;
                p = i;
            }
        }

        return ((p == -1) || (p == 1) || (p == nums.length - 1) || (nums[p - 2] <= nums[p])
                || (nums[p - 1] <= nums[p + 1]));
    }
}