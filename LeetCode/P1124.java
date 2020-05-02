// Longest Well-Performing Interval
import java.util.*;
public class P1124 {
    public int longestWPI(int[] hours) {
        int ans = 0;
        int score = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = hours.length;
        for (int i = 0; i < n; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                ans = i + 1;
            } else {
                map.putIfAbsent(score, i);
                if (map.containsKey(score - 1)) {
                    ans = Math.max(ans, i - map.get(score - 1));
                }
            }
        }
        return ans;
    }
}