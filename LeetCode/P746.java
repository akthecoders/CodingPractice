// Min Cost Climbing Stairs
public class P746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1;
        int[] memory = new int[n + 1];
        memory[n] = cost[n];
        memory[n - 1] = cost[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int cost1 = cost[i] + memory[i + 1];
            int cost2 = cost[i] + memory[i + 2];
            memory[i] = Math.min(cost1, cost2);
        }

        return memory[0] < memory[1] ? memory[0] : memory[1];
    }
}