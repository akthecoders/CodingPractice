//Third Maximum Number
public class P414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int x : nums) {
            if (first < x) {
                third = second;
                second = first;
                first = x;
            } else if (second < x && x != first) {
                third = second;
                second = x;
            } else if (third < x && x != first && x != second) {
                third = x;
            }
        }
        return third == Long.MIN_VALUE ? (int) first : (int) third;
    }
}