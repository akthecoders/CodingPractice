//Max Consecutive Ones
public class P485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                while (i < nums.length && nums[i] == 1) {
                    i++;
                }
                i--;
                end = i;
                max = Math.max(max, end - start + 1);
            } else {
                while (i < nums.length && nums[i] == 0) {
                    i++;
                }
                start = i;
                i--;
            }
        }
        return max;
    }
}