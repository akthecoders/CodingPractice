import java.util.Arrays;

/**
 * Knapsack01
 */
public class Knapsack01Recursive {

    public static void main(String[] args) {
        int value[] = {1, 4, 6, 3};
        int weight[] = {2, 2, 8, 5};
        int cap = 7;
        int memory[][] = new int[cap + 1][value.length + 1];
        for(int x[]: memory) {
            Arrays.fill(x, -1);
        }
        System.out.println(getMaxProfit(value, weight, cap, value.length, memory));
    }

    public static int getMaxProfit(int[] value, int[] weight, int cap, int n, int memory[][]) {
        if(cap == 0 || n == 0) return 0;
        if(memory[cap][n] != -1) return memory[cap][n];
        if(weight[n-1] < cap) {
            return memory[cap][n] = Math.max(value[n-1] + getMaxProfit(value, weight, cap - weight[n-1], n - 1, memory), getMaxProfit(value, weight, cap, n - 1, memory));
        }
        else {
            return memory[cap][n] = getMaxProfit(value, weight, cap, n - 1, memory);
        }
    }

}