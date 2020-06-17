import java.util.HashMap;

//Longest String Chain
public class P1048 {
    public int longestStrChain(String[] words) {

        HashMap<String, Integer> memo = new HashMap<>();
        for (String word : words) {
            memo.put(word, -1);
        }

        int max = Integer.MIN_VALUE;
        for (String word : words) {
            max = Math.max(max, helper(memo, word));
        }
        return max;

    }

    public int helper(HashMap<String, Integer> memo, String current) {
        if (memo.get(current) != -1) {
            return memo.get(current);
        }
        memo.put(current, 1);
        StringBuilder sb = new StringBuilder(current);
        for (int i = 0; i < current.length(); i++) {
            sb.deleteCharAt(i);
            if (memo.containsKey(sb.toString())) {
                int parent = helper(memo, sb.toString());
                memo.put(current, Math.max(memo.get(current), parent + 1));
            }
            sb.insert(i, current.charAt(i));
        }

        return memo.get(current);

    }
}