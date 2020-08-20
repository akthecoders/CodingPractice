//Sort Colors
public class P75 {
    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0;
        int p2 = nums.length - 1;
        int tmp;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[curr];
                nums[curr++] = nums[p0];
                nums[p0++] = tmp;
            } else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else
                curr++;
        }
    }
}