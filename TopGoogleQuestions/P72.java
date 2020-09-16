import java.util.Arrays;

//Edit Distance
public class P72 {
    int[][] memory;

    public int minDistance(String word1, String word2) {
        int s1l = word1.length();
        int s2l = word2.length();
        if (s1l == 0 && s2l == 0)
            return 0;
        if (s2l == 0)
            return s1l;
        if (s1l == 0)
            return s2l;
        memory = new int[s1l + 1][s2l + 1];
        for (int[] m : memory) {
            Arrays.fill(m, -1);
        }

        helper(word1, word2, s1l, s2l);
        return memory[s1l][s2l] == -1 ? 0 : memory[s1l][s2l];
    }

    public int helper(String s1, String s2, int s1l, int s2l) {
        if (s1l == 0 && s2l == 0)
            return 0;
        if (s2l == 0)
            return s1l;
        if (s1l == 0)
            return s2l;

        if (memory[s1l][s2l] != -1)
            return memory[s1l][s2l];
        if (s1.charAt(s1l - 1) == s2.charAt(s2l - 1)) {
            memory[s1l][s2l] = helper(s1.substring(0, s1l - 1), s2.substring(0, s2l - 1), s1l - 1, s2l - 1);
        } else {
            int insert = helper(s1, s2.substring(0, s2l - 1), s1l, s2l - 1) + 1;
            int remove = helper(s1.substring(0, s1l - 1), s2, s1l - 1, s2l) + 1;
            int replace = helper(s1.substring(0, s1l - 1), s2.substring(0, s2l - 1), s1l - 1, s2l - 1) + 1;

            memory[s1l][s2l] = Math.min(insert, Math.min(remove, replace));

        }
        return memory[s1l][s2l];
    }
}
