//Decrease Elements To Make Array Zigzag
public class P1144 {
    public int movesToMakeZigzag(int[] nums) {
        int oddmove = 0;
        int evenmove = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = (i > 0) ? nums[i - 1] : Integer.MAX_VALUE;
            int right = (i < nums.length - 1) ? nums[i + 1] : Integer.MAX_VALUE;

            if (i % 2 == 0) {
                if (nums[i] < Math.min(left, right))
                    continue;
                else if (nums[i] >= Math.min(left, right))
                    evenmove += nums[i] - (Math.min(left, right) - 1);
                else if (nums[i] >= Math.max(left, right))
                    evenmove += nums[i] - (Math.max(left, right) - 1);

                System.out.println(evenmove);
            }

            if (i % 2 == 1) {
                if (nums[i] < Math.min(left, right))
                    continue;
                else if (nums[i] >= Math.min(left, right))
                    oddmove += nums[i] - (Math.min(left, right) - 1);
                else if (nums[i] >= Math.max(left, right))
                    oddmove += nums[i] - (Math.max(left, right) - 1);
            }
        }

        return Math.min(oddmove, evenmove);
    }
}