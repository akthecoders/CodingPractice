import java.util.HashMap;
import java.util.Map;

//Minimum Number of Steps to Make Two Strings Anagram
public class P1347 {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        int ans = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            ans += Math.abs(entry.getValue());
        }
        return ans / 2;
    }
}