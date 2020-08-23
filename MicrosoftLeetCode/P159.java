import java.util.HashMap;

//Longest Substring with At Most Two Distinct Characters
public class P159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] ca = s.toCharArray();

        int i = 0, j = 0;
        int n = s.length();
        int res = 0;
        while (i < n && j < n) {
            char c = ca[j];
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > 2) {
                char cr = ca[i];
                i++;
                int count = map.get(cr);
                if (count == 1) {
                    map.remove(cr);
                } else {
                    map.put(cr, count - 1);
                }
            }
            j++;
            res = Math.max(res, j - i);
        }
        return res;
    }
}