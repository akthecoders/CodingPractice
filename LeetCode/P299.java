import java.util.HashMap;
import java.util.Map;

//Bulls and Cows
public class P299 {
    public String getHint(String s, String g) {
        int A = 0;
        int B = 0;

        Map<Character, Integer> a = new HashMap<>();
        Map<Character, Integer> b = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == g.charAt(i)) {
                A++;
            } else {
                a.computeIfAbsent(s.charAt(i), k -> 0);
                b.computeIfAbsent(g.charAt(i), k -> 0);
                a.put(s.charAt(i), a.get(s.charAt(i)) + 1);
                b.put(g.charAt(i), b.get(g.charAt(i)) + 1);
            }
        }
        for (char c : a.keySet()) {
            if (b.containsKey(c)) {
                B += Math.min(a.get(c), b.get(c));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(A).append("A").append(B).append("B");
        return sb.toString();
    }
}