import java.util.HashMap;
import java.util.Map;

//Longest Substring with At Most K Distinct Characters
public class P340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0)
            return 0;
        if (k == 0)
            return 0;

        int left = 0;
        int right = 0;
        int n = s.length();
        ;
        int maxLen = 0;
        int currLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (left < n && right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            currLen++;
            right++;
            while (map.size() > k) {
                char l = s.charAt(left);
                int count = map.get(l);
                count -= 1;
                if (count <= 0) {
                    map.remove(l);
                } else {
                    map.put(l, count);
                }
                left++;
                currLen--;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}