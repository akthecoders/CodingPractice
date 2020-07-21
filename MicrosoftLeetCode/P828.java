import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Count Unique Characters of All Substrings of a Given String
public class P828 {
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index.computeIfAbsent(c, x -> new ArrayList<>()).add(i);
        }

        long ans = 0;
        for (List<Integer> A : index.values()) {
            for (int i = 0; i < A.size(); i++) {
                long prev = i > 0 ? A.get(i - 1) : -1;
                long next = i < A.size() - 1 ? A.get(i + 1) : s.length();
                ans += (A.get(i) - prev) * (next - A.get(i));
            }
        }
        return (int) ans % 1_000_000_007;
    }
}
