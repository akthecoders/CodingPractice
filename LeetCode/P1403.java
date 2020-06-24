import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Minimum Subsequence in Non-Increasing Order
public class P1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();

        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int curr = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (curr > totalSum - curr) {
                break;
            }
            res.add(nums[i]);
            curr += nums[i];
        }
        return res;
    }
}