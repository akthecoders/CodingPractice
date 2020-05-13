//Longest Substring Without Repeating Characters
import java.util.HashSet;

public class P3 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int aP = 0;
        int bP = 0;
        int maxLen = 0;
        while (bP < s.length() && aP < s.length()) {
            if (!set.contains(s.charAt(bP))) {
                set.add(s.charAt(bP));
                bP++;
                maxLen = Math.max(set.size(), maxLen);
            } else {
                set.remove(s.charAt(aP));
                aP++;
            }
        }
        return maxLen;
    }
}