public class CountSubSetSum {
    public static void main(String[] args) {
        int[] subset = {2,3,5,6,8,10};
        int target = 10;
        int memory[][] = new int[subset.length + 1][target + 1];
        for(int i = 0; i <= subset.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0) memory[i][j] = 0;
                if(j == 0) memory[i][j] = 1;
            }
        }
        System.out.println(recursive(subset, subset.length - 1, target));
        bottomup(subset, target, memory);
        System.out.println(memory[subset.length][target]);
    }


    public static void bottomup(int[] subset, int target, int[][] memory) {
        for(int i = 1; i <= subset.length; i++) {
            for(int j = 1; j <= target; j++) {
                if(subset[i-1] <= j) {
                    memory[i][j] = memory[i-1][j] + memory[i-1][j - subset[i - 1]];
                }
                else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
    }

    public static int recursive(int[] subset, int n , int target) {
        if(0 >= n && target == 0) return 1;
        if(0 > n ) return 0;

        if(subset[n] <= target) {
            return recursive(subset, n - 1, target) + recursive(subset, n - 1, target - subset[n]);
        }
        return recursive(subset, n - 1, target);
    }

}