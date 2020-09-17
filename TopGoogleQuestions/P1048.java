import java.util.Arrays;
import java.util.HashMap;

//Longest String Chain
public class P1048 {
    public int longestStrChain(String[] words) {
        if (words.length == 0)
            return 0;
        int res = 0;
        HashMap<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String s : words) {
            if (s.length() == 1) {
                map.put(s, 1);
                continue;
            }
            int localMax = 0;
            for (int i = 0; i < s.length(); i++) {
                String temp = exclude(s, i);
                map.put(s, map.getOrDefault(temp, 0) + 1);
                localMax = Math.max(localMax, map.get(s));
            }
            map.put(s, localMax);
            res = Math.max(res, map.get(s));
        }
        return res;
    }

    public String exclude(String s, int pos) {
        if (pos == 0)
            return s.substring(1, s.length());
        if (pos == s.length())
            return s.substring(0, s.length() - 1);
        return s.substring(0, pos) + s.substring(pos + 1, s.length());
    }
}
