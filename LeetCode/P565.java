//Array Nesting
public class P565 {
    public int arrayNesting(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        boolean[] visited = new boolean[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                } while (start != nums[i]);
                sum = Math.max(sum, count);
            }
        }
        return sum;
    }
}