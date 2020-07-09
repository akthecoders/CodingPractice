public class NoofSubSetWithGivenDiff {
    public static void main(String[] args) {
        int[] subset = {1,1,2,3};
        int targetDiff = 1;
        int sum = 0;
        for(int x: subset) sum += x;

        int target = ( sum + targetDiff ) / 2; 

        int memory[][] = new int[subset.length + 1][target + 1];
        for(int i = 0; i <= subset.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0) memory[i][j] = 0;
                if(j == 0) memory[i][j] = 1;
            }
        }

        bottomup(subset, target, memory);
        System.out.println(memory[subset.length][target]);
    }

    public static void bottomup(int[] subset, int target, int[][] memory) {
        for(int i = 1; i <= subset.length; i++) {
            for(int j = 1; j <= target; j++) {
                if(subset[i - 1] <= j) {
                    memory[i][j] = memory[i-1][j] + memory[i-1][j - subset[i-1]];
                }
                else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
    }
}