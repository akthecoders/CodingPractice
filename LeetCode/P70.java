// Climbing Stairs
public class P70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int[] memory = new int[n + 1];
        memory[1] = 1;
        memory[2] = 2;

        for (int i = 3; i <= n; i++)
            memory[i] = memory[i - 1] + memory[i - 2];
        return memory[n];
    }
}