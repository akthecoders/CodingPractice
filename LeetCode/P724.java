//Find Pivot Index
public class P724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int pi = 0;
        int pSum = 0;
        while (pi < nums.length) {
            if (sum - pSum - nums[pi] == pSum) {
                return pi;
            }
            pSum += nums[pi];
            pi++;
        }
        return -1;
    }
}