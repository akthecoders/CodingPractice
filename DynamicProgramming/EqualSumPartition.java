public class EqualSumPartition {
    public static void main(String[] args) {
        int[] subset = {2, 2, 8, 5, 3};
        int target = 0;
        for(int x: subset) {
            target += x;
        }
        if(target % 2 != 0) {
            System.out.println("false");
            return;
        }
        target = target / 2;
        boolean memory[][] = new boolean[subset.length + 1][target + 1];
        for(int i = 0; i <= subset.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0) memory[i][j] = false;
                if(j == 0) memory[i][j] = true;
            }
        }

        System.out.println(recursive(subset, subset.length - 1, target));
        bottomup(subset, target, memory);
        System.out.println(memory[subset.length][target]);
    }

    public static void bottomup(int[] subset, int target, boolean[][] memory) {
        for(int i = 1; i <= subset.length; i++) {
            for(int j = 1; j <= target; j++) {
                if(subset[i-1] <= j) {
                    memory[i][j] = memory[i-1][j] || memory[i-1][j-subset[i-1]];
                }
                else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
    }

    public static boolean recursive(int[] subset, int n, int target) {
        if(0 >= n && target == 0) return true;
        if(0 > n ) return false;

        if(subset[n] <= target) {
            return recursive(subset, n - 1, target) || recursive(subset, n - 1, target - subset[n]);
        }
        return recursive(subset, n - 1, target);
    } 
}