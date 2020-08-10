// Shuffle the Array
public class P1470 {
    public int[] shuffle(int[] nums, int n) {
        if (nums.length == 0)
            return nums;
        int res[] = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index++] = nums[i];
            res[index++] = nums[i + n];
        }
        return res;
    }
}