public class Subset {
    public static void main(String[] args) {
        int target = 8;
        int[] subset = {1, 2, 8, 5, 3};

        boolean memory[][] = new boolean[subset.length + 1][target + 1];
        for(int i = 0; i <= subset.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0) memory[i][j] = false;
                if(j == 0) memory[i][j] = true;
            }
        }

        // System.out.println(recursive(subset, 0, subset.length - 1, target));
        bottomup(subset, target, memory);
        System.out.println(memory[subset.length][target]);
    }

    public static void bottomup(int[] subset, int target, boolean memory[][]) {
        for(int i = 1; i <= subset.length; i++) {
            for(int j = 1; j <= target; j++) {
                if(subset[i - 1] < j) {
                    memory[i][j] = memory[i][j - subset[i-1]] || memory[i-1][j];
                }
                else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
    }

    public static boolean recursive(int[] subset, int start, int end, int target) {
        if(start >= end && target == 0) return true;
        if(start > end ) return false;

        if(target >= subset[end]) {
            return recursive(subset, start, end - 1, target) || recursive(subset, start, end - 1, target - subset[end]);
        }
        else {
            return recursive(subset, start, end - 1, target);
        }
    }
    
    

}