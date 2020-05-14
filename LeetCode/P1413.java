//Minimum Value to Get Positive Step by Step Sum
public class P1413 {
    public int minStartValue(int[] nums) {
        int prev = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            prev = prev + nums[i];
            sum = Math.max(-1 * prev + 1, sum);
        }
        if (sum == 0) {
            return 1;
        }
        return sum;
    }
}