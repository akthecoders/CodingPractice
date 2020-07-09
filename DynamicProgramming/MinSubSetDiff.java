import java.util.ArrayList;
import java.util.List;

public class MinSubSetDiff {
    public static void main(String[] args) {
        int[] subset = { 2, 8, 5, 3};

        int target = 0;
        for(int x : subset) target += x;

        boolean memory[][] = new boolean[subset.length + 1][target + 1];
        for(int i = 0; i <= subset.length; i++) {
            for(int j = 0; j <= target; j++) {
                if(i == 0) memory[i][j] = false;
                if(j == 0) memory[i][j] = true;
            }
        }
        
        bottomup(subset, target, memory);
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= target/2; i++) {
            if(memory[subset.length][i]) {
                list.add(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <list.size(); i++) {
            int val = list.get(i);
            min = Math.min(min, target - 2 * val);
        }
        System.out.println("min Diff : " + min);
    }

    public static void bottomup(int[] subset, int target, boolean memory[][]) {
        for(int i = 1; i <= subset.length; i++) {
            for(int j = 1; j <= target; j++) {
                if(subset[i - 1] <= j) {
                    memory[i][j] = memory[i-1][j] || memory[i-1][j - subset[i-1]];
                }
                else {
                    memory[i][j] = memory[i-1][j];
                }
            }
        }
    }
}