import java.util.HashMap;

//Isomorphic Strings
public class P2015 {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map.containsKey(ch)) {
                if (map.get(ch) != ch2)
                    return false;
            } else {
                if (map.containsKey(ch2))
                    return false;
                map.put(ch, ch2);
            }
        }
        return true;
    }
}