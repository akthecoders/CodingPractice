import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Word Break
public class P139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_break(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_break(String s, Set<String> dict, int start, Boolean[] memo) {
        if (start == s.length())
            return true;
        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(start, end)) && word_break(s, dict, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        return memo[start] = false;
    }
}
