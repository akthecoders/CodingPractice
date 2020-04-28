// Range Sum Query - Immutable
public class P303 {
    int memory[];

    public void NumArray(int[] nums) {
        if(nums.length == 0) {
            return;
        }
        
        memory = new int[nums.length];
        memory[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            memory[i] = memory[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (memory == null) {
            return 0;
        }
        if (i == 0) {
            return memory[j];
        }
        return memory[j] - memory[i - 1];
    }
}