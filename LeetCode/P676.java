import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Implement Magic Dictionary
public class P676 {
    Map<Integer, ArrayList<String>> buckets;

    /** Initialize your data structure here. */
    public P676() {
        buckets = new HashMap<>();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            buckets.computeIfAbsent(word.length(), x -> new ArrayList<>()).add(word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after
     * modifying exactly one character
     */
    public boolean search(String word) {
        if (!buckets.containsKey(word.length()))
            return false;
        for (String candidate : buckets.get(word.length())) {
            int mismatch = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != candidate.charAt(i)) {
                    if (++mismatch > 1)
                        break;
                }
            }
            if (mismatch == 1)
                return true;
        }
        return false;
    }
}