
public class P1295 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (digits(nums[i]) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public int digits(int num) {
        if (num <= 0) {
            return 0;
        }
        return 1 + digits(num / 10);
    }
}