//Circular Array Loop
public class P457 {
    private int[] visited;

    public boolean circularArrayLoop(int[] nums) {
        visited = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (visited[0] == 0 && dfs(nums, i, nums[i] > 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int[] nums, int i, boolean forward) {
        if (visited[i] == -1) {
            return true;
        } else if (visited[i] == 1) {
            return false;
        } else if ((nums[i] > 0) ^ forward) {
            return false;
        }
        int next = Math.floorMod(nums[i] + i, nums.length);
        if (next == i) {
            return false;
        }
        visited[next] = -1;
        boolean res = dfs(nums, next, forward);
        visited[next] = 1;
        return res;
    }
}