public class CoinChangeII {
    public static void main(String[] args) {
        int[] subset = {25, 10 , 5};
        int target = 30;
        int memory[][] = new int[subset.length + 1][target + 1];
        for(int i = 0; i <= subset.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(j == 0) memory[i][j] = 0;
                if(i == 0) memory[i][j] = Integer.MAX_VALUE - 1;
            }
        }
        for(int i = 1; i <= target; i++) {
            if(i %subset[0] == 0) {
                memory[1][i] = i/subset[0];
            }
            else {
                memory[1][i] = Integer.MAX_VALUE-1;
            }
        }
        bottomup(subset, target, memory);
        System.out.println(memory[subset.length][target]);
    }

    public static void bottomup(int[] subset, int target, int[][] memory) {
        for(int i = 1; i <= subset.length; i++) {
            for(int j = 1; j <= target; j++) {
                if(subset[i - 1] <= j) {
                    memory[i][j] = Math.min(memory[i-1][j], 1 + memory[i][j - subset[i-1]]);
                }
                else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
    }
}
