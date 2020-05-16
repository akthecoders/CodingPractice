import java.util.HashMap;

//Number of Equivalent Domino Pairs
public class P1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map =new HashMap<>();
        int result = 0;
        for( int[] row : dominoes) {
            int a = Math.min(row[0], row[1]);
            int b = Math.max(row[0], row[1]);
            
            int key = getKey(a, b);
            result += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return result;
    }
    
    public int getKey(int a, int b) {
        return a*10 + b;
    }
}