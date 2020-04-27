// Partition to K Equal Sum Subsets

public class P698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int n: nums) {
            sum += n;
        }
        if (k == 0 || sum % k != 0) {
            return false;
        }

        return partition(0, nums, k, new boolean[nums.length], 0, sum / k);
    }

    public boolean partition(int start, int[] nums, int k, boolean[] visited, int currSum, int targetSum) {
        if (k == 1) {
            return true;
        }
        if (currSum == targetSum) {
            return partition(0, nums, k - 1, visited, 0, targetSum);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (partition(i + 1, nums, k, visited, currSum + nums[i], targetSum)) {
                    return true;
                }

                visited[i] = false;
            }
        }
        return false;
    }
}