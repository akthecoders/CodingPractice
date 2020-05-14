//Repeated Substring Pattern
public class P459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (removeAll(s.substring(0, i), s)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(String p, String s) {
        if (s.length() % p.length() != 0)
            return false;
        for (int i = p.length(); i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i % p.length()))
                return false;
        }
        return true;
    }
}