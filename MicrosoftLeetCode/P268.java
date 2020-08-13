//Missing Number
public class P268 {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int o = 0;
        for (int i = 0; i < nums.length; i++) {
            o += (i + 1);
            sum += nums[i];
        }
        return o - sum;
    }
}