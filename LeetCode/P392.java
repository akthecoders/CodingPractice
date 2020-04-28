// Is Subsequence
public class P392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0 && s.length() > 0) {
            return false;
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(0)) {
                if (i == t.length() - 1 && s.length() > 1) {
                    return false;
                }
                if (i == t.length() - 1 && s.length() == 1) {
                    return true;
                }
                if (isSubsequence(s.substring(1), t.substring(i + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}