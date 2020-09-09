//Maximum Subarray
public class P53 {
    public int maxSubArray(int[] nums) {

        int maxSoFar = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (maxSoFar < sum) {
                maxSoFar = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSoFar;
    }
}
