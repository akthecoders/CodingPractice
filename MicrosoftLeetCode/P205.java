import java.util.HashSet;

//Isomorphic Strings
public class P205 {
    public boolean isIsomorphic(String s, String t) {
        char[] map = new char[127];
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 0) {
                if (set.contains(t.charAt(i)))
                    return false;
                map[s.charAt(i)] = t.charAt(i);
                set.add(t.charAt(i));
            } else if (map[s.charAt(i)] != t.charAt(i))
                return false;
        }
        return true;
    }
}